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

    // 400 BAD REQUEST
    INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "파라미터 값을 확인해주세요."),

    // 404 NOT FOUND
    BOARD_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 방 번호 입니다."),
    YOUR_NOT_MEMBER(HttpStatus.NOT_FOUND, "회원이 아닙니다."),
    RESOURCE_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "현재 요청사항을 찾지 못했습니다. id를 다시 확인해주세요."),

    SAVED_BOARD_NOT_FOUND(HttpStatus.NOT_FOUND, "저장된 게시판이 아닙니다."),

    // 409 CONFLICT 중복된 리소스
    ALREADY_SAVED_BOARD(HttpStatus.CONFLICT, "이미 저장된 방입니다."),

    // 500 INTERNAL SERVER ERROR
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 에러가 발생했습니다. 서버에 연락주세요.")

}