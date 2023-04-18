package study.kotlin.boardtoyproject.common.exception

open class CustomException(private val errorCode: ErrorCode) : RuntimeException() {
    // 404, 409 에러들은 따로 잡아주어야 하기 때문에 필요한 클래스

    fun getErrorCode(): ErrorCode{
        return errorCode
    }
}