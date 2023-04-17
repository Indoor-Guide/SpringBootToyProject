package study.kotlin.boardtoyproject.board.controller

import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import study.kotlin.boardtoyproject.board.dto.PostDto
import study.kotlin.boardtoyproject.board.service.PostService
import java.io.IOException
import java.rmi.RemoteException
import javax.validation.Valid

@RestController
@RequestMapping("/api/posts")
class PostController(private val postService: PostService) {

    @GetMapping
    fun getAllPosts(): List<PostDto> {
        return postService.getAllPosts()
    }

    // id를 통해 데이터 조회
    @GetMapping("/{id}")
    fun getPostById(@PathVariable id: Long): ResponseEntity<PostDto> {
        val postDto = postService.getPostById(id)
        return ResponseEntity.ok(postDto)
    }

    // Post 생성
    @PostMapping
    fun createPost(@Valid @RequestBody postDto: PostDto, bindingResult: BindingResult): ResponseEntity<*> {
        return ResponseEntity.ok(postService.createPost(postDto))
    }

    // id 조회 후, 해당 데이터 입력된 것으로 변경
    @PutMapping("/{id}")
    fun updatePost(@PathVariable id: Long, @RequestBody postDto: PostDto): ResponseEntity<PostDto> {
        val updatedPostDto = postService.updatePost(id, postDto)
        return ResponseEntity.ok(updatedPostDto)
    }

    @ExceptionHandler(value = [FileSystemException::class, RemoteException::class])
    fun handle(ex: IOException): ResponseEntity<String>{

    }

    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable id: Long): ResponseEntity<Void> {
        postService.deletePost(id)
        return ResponseEntity.noContent().build()
    }
}