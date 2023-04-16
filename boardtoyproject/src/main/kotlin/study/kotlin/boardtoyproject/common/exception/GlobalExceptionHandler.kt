package study.kotlin.boardtoyproject.common.exception

import org.h2.api.ErrorCode
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import study.kotlin.boardtoyproject.board.dto.response.ErrorResponse

@RestController
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    fun handleMethodArgumentTypeMismatchException(e: MethodArgumentTypeMismatchException): ResponseEntity<ErrorResponse>{
        val errorCode = ErrorCode.INVALID_TYPE_VALUE
        val errorMessage = "${e.name} should be of type ${e.requiredType?.simpleName}"
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse(errorCode, errorMessage))
    }
}