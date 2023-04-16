package study.kotlin.boardtoyproject.board.entity

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


// entity 생성

@Entity
data class Post(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val title: String,
        val content: String,
        val createAt: LocalDateTime = LocalDateTime.now(),
        val updateAt: LocalDateTime = LocalDateTime.now()
)