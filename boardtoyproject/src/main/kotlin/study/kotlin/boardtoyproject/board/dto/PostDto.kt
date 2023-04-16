package study.kotlin.boardtoyproject.board.dto

import study.kotlin.boardtoyproject.board.entity.Post
import java.time.LocalDateTime

data class PostDto(
        val id: Long?,
        val title: String,
        val content: String,
        val createAt: LocalDateTime,
        val updateAt: LocalDateTime
) {
    companion object {
        fun fromEntity(post: Post): PostDto{
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