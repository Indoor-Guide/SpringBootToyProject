package study.kotlin.boardtoyproject.common.exception.dto.response

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import study.kotlin.boardtoyproject.common.exception.ErrorCode
import java.time.LocalDateTime


data class ErrorResponse(
        val timestamp: LocalDateTime = LocalDateTime.now(),
        val status: Int,
        val message: String?,
        val errors: List<FieldError>
){

    // static
    companion object {
        
        // 메서드
        fun toResponseEntity(errorCode: ErrorCode): ResponseEntity<ErrorResponse?> {
            return ResponseEntity.status(errorCode.status).body(ErrorResponse(errorCode))
        }

        fun toResponseEntity(result: BindingResult?): ResponseEntity<ErrorResponse?> {
            return ResponseEntity.badRequest().body(result?.let { ErrorResponse(it) })
        }

        // 생성자
        data class FieldError(
                val field: String,
                val value: String?,
                val reason: String?
        ) {
            companion object {
                fun of(bindingResult: BindingResult): List<FieldError> {
                    val fieldErrors = bindingResult.fieldErrors
                    return fieldErrors.map { error ->
                        FieldError(
                                error.field,
                                error.rejectedValue?.toString(),
                                if (error.code == "typeMismatch") "입력 값에 대한 예외 입니다" else error.defaultMessage
                        )
                    }
                }
            }
        }
    }
    // 생성자
    constructor(errorCode: ErrorCode) : this(
            status = errorCode.status.value(),
            message = errorCode.message,
            errors = emptyList()
    )

    constructor(result: BindingResult): this(
            status = HttpStatus.BAD_REQUEST.value(),
            message = "입력 조건에 대한 예외입니다.",
            errors = FieldError.of(result)
    )
}