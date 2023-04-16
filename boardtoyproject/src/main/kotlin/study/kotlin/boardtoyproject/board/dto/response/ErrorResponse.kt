package study.kotlin.boardtoyproject.board.dto.response

import org.h2.api.ErrorCode

data class ErrorResponse(
        val code: ErrorCode,
        val message: String
)