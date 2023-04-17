package study.kotlin.boardtoyproject.common.exception.dto.response

import study.kotlin.boardtoyproject.common.exception.ErrorCode


data class ErrorResponse(
        val code: ErrorCode,
        val message: String?
)