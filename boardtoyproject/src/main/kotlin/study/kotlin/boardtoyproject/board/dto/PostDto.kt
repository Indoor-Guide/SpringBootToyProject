package study.kotlin.boardtoyproject.board.dto

import study.kotlin.boardtoyproject.board.entity.Post
import java.time.LocalDateTime
import java.util.*

data class PostDto(
        val id: Long?,
        val title: String,
        val content: String,
        val createAt: LocalDateTime,
        val updateAt: LocalDateTime
) {
    companion object {

        //object PostDto {
        //    fun fromEntity(post: Post?): PostDto? {
        //        return post?.let {
        //            PostDto(
        //                id = it.id,
        //                title = it.title,
        //                content = it.content
        //            )
        //        }
        //    }
        //}

        fun fromEntity(post: Post): PostDto {
            return PostDto(
                    id = post.id,
                    title = post.title,
                    content = post.content,
                    createAt = post.createAt,
                    updateAt = post.updateAt

            )
        }
    }
}
