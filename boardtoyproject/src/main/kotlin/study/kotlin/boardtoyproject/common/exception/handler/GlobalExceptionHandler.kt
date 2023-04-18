package study.kotlin.boardtoyproject.common.exception.handler


import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import study.kotlin.boardtoyproject.common.exception.CustomException
import study.kotlin.boardtoyproject.common.exception.dto.response.ErrorResponse


@RestControllerAdvice
class GlobalExceptionHandler {
    /* 설명
    RESTful API에서 발생하는 예외 처리를 담당
    예외 처리를 통해 클라이언트에게 적절한 에러 응답을 보내는 것이 중요하다.
    Spring Framework에서 예외 처리를 담당하는 @RestControllerAdvice 클래스인 GlobalExceptionHandler
    (1) handleCustomException
    - CustomException 발생 시 호출되는 메소드
    - CustomException에서 발생한 ErrorCode 객체를 이용하여 ErrorResponse 객체를 생성하여 반환

    (2) handleBindException
    - BindException 발생 시 호출되는 메소드
    - BindException에서 발생한 BindingResult 객체를 이용하여 ErrorResponse 객체를 생성하여 반환
    */

    private val logger = KotlinLogging.logger {}
    @ExceptionHandler(value = [CustomException::class])
    protected fun handleCustomException(e: CustomException): ResponseEntity<ErrorResponse?>? {
        return ErrorResponse.toResponseEntity(e.getErrorCode())
    }

    @ExceptionHandler(value = [BindException::class])
    protected fun handleBindException(e: BindException): ResponseEntity<ErrorResponse?>? {
        logger.error("BindException : {}", e.message)
        return ErrorResponse.toResponseEntity(e.bindingResult)
    }
}