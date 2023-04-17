package study.kotlin.boardtoyproject.common.exception

class CustomException(private val errorCode: ErrorCode) : RuntimeException() {
}