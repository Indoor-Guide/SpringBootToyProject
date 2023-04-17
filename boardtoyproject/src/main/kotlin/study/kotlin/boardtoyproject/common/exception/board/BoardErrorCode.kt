package study.kotlin.boardtoyproject.common.exception.board

import org.springframework.http.HttpStatus
import study.kotlin.boardtoyproject.common.exception.ErrorCode

enum class BoardErrorCode(override val status:HttpStatus, override val message: String) : ErrorCode{

    BOARD_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 방 번호 입니다.")

}