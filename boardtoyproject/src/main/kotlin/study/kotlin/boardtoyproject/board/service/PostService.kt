package study.kotlin.boardtoyproject.board.service

import com.fasterxml.jackson.databind.RuntimeJsonMappingException
import org.springframework.stereotype.Service
import study.kotlin.boardtoyproject.board.dto.PostDto
import study.kotlin.boardtoyproject.board.entity.Post
import study.kotlin.boardtoyproject.common.exception.ResourceNotFoundException
import study.kotlin.boardtoyproject.board.repository.PostRepository
import java.time.LocalDateTime


@Service
class PostService(private val postRepository: PostRepository) {

    // 모든 데이터 조회
    fun getAllPosts(): List<PostDto> {
        return postRepository.findAll().map {
            PostDto.fromEntity(it)
        }
    }

    // id를 통해 요청 데이터를 조회
    fun getPostById(id: Long): PostDto{
        val post = postRepository.findById(id).orElseThrow{ ResourceNotFoundException("Post not found with id: $id") }
        return PostDto.fromEntity(post)
    }


    // PostDto 생성
    fun createPost(postDto: PostDto): PostDto {
        val post = Post(
                title = postDto.title,
                content = postDto.content
        )
        //  다른 필드는 기본값을 가지고 있으므로, 값을 직접 지정하지 않아도 된다.

        return PostDto.fromEntity(postRepository.save(post))
    }

    // post update
    fun updatePost(id: Long, postDto: PostDto): PostDto {
        val post = postRepository.findById(id).orElseThrow{ ResourceNotFoundException("Post not found with id: $id") }
        val updatedPost = post.copy(
                title = postDto.title,
                content = postDto.content,
                updateAt = LocalDateTime.now()
        )
        return PostDto.fromEntity(postRepository.save(updatedPost))

    }

    // post delete
    fun deletePost(id: Long){
       val post = postRepository.findById(id).orElseThrow{ ResourceNotFoundException("Post not found with id: $id") }
        postRepository.delete(post)
    }
}