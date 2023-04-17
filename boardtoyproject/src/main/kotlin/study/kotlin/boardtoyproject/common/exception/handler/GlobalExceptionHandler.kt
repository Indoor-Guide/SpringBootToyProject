package study.kotlin.boardtoyproject.common.exception.handler


import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import study.kotlin.boardtoyproject.common.exception.dto.response.ErrorResponse
import study.kotlin.boardtoyproject.common.exception.ResourceNotFoundException
import study.kotlin.boardtoyproject.common.exception.auth.AuthErrorCode

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    fun handleMethodArgumentTypeMismatchException(e: MethodArgumentTypeMismatchException): ResponseEntity<ErrorResponse> {
        val errorCode = AuthErrorCode.INVALID_TYPE_VALUE
        val errorMessage = "${e.name} should be of type ${e.requiredType?.simpleName}"
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse(errorCode, errorMessage))
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundException(e: ResourceNotFoundException): ResponseEntity<ErrorResponse> {
        val errorCode = AuthErrorCode.RESOURCE_NOT_FOUND
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse(errorCode, e.message))
    }

    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(e: RuntimeException): ResponseEntity<ErrorResponse> {
        val errorCode = AuthErrorCode.INTERNAL_SERVER_ERROR
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse(errorCode, e.message))
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ErrorResponse> {
        val errorCode = AuthErrorCode.INTERNAL_SERVER_ERROR
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse(errorCode, e.message))
    }

    @ExceptionHandler
    fun handleBindingResultErrors(e: BindException): ResponseEntity<ErrorResponse> {
        val errorCode = AuthErrorCode.INVALID_INPUT_VALUE
        val bindingResult = e.bindingResult
        val errorMessage = bindingResult.allErrors
                .map { "${it.defaultMessage} [${it.codes?.joinToString()}]" }
                .joinToString("\n")
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse(errorCode, errorMessage))
    }
}