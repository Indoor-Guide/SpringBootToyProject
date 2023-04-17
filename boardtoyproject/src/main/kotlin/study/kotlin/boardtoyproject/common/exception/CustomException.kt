package study.kotlin.boardtoyproject.common.exception

open class CustomException(private val errorCode: ErrorCode) : RuntimeException() {

    fun getErrorCode(): ErrorCode{
        return errorCode
    }
}