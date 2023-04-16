package study.kotlin.boardtoyproject.board.repository

import org.springframework.data.jpa.repository.JpaRepository
import study.kotlin.boardtoyproject.board.entity.Post

interface PostRepository : JpaRepository<Post, Long>