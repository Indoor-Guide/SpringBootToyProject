package study.kotlin.boardtoyproject.common.exception.board

import org.springframework.http.HttpStatus
import study.kotlin.boardtoyproject.common.exception.ErrorCode

/*
 Enum class로 사용할 에러들을 적어준다.
 status 값과 error message 만 프론트에 넘겨줄 예정으로 두 개만 작성
 status 타입으로 HTTPStatus를 사용
 */

/*
 에러 코드와 같이 성공했을 때 SuccessCode도 있으면 좋을 것 같다.
*/


enum class BoardErrorCode(override val status:HttpStatus, override val message: String) : ErrorCode{

    BOARD_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 방 번호 입니다.")

}