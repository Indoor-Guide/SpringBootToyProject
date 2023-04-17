package study.kotlin.boardtoyproject.common.exception.auth



import org.springframework.http.HttpStatus
import study.kotlin.boardtoyproject.common.exception.ErrorCode

enum class AuthErrorCode(override val status: HttpStatus, override val message: String) : ErrorCode {
    INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST, "입력된 Type이 잘못되었습니다."),
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "입력된 값을 찾지 못했습니다."),
    INVALID_IDENTITY_TOKEN(HttpStatus.BAD_REQUEST, "유효하지 않은 identity 토큰입니다."),
    RESOURCE_NOT_FOUND(HttpStatus.BAD_REQUEST, "입력된 Data를 찾지못했습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "인터넷 서버 오류, 서버를 찾지 못했습니다."),
}