package study.kotlin.boardtoyproject.common.exception.board

import study.kotlin.boardtoyproject.common.exception.CustomException
import study.kotlin.boardtoyproject.common.exception.ErrorCode


/* private constructor를 왜 사용할까?
 - 생성자의 접근 제어자를 private으로 선언한 것을 의미한다.
 - 이는 해당 클래스 내에서만 인스턴스 생성이 가능하도록 제한하는 역할을 한다.
 - 보통 이를 사용하는 경우는 다음과 같습니다.
 => 정적 메서드만으로 객체 생성을 제어하고 싶을 때
 => 싱글톤 패턴 구현 시

 Kotlin에서도 Java와 마찬가지로 private constructor를 지원한다.
 이를 사용하여 클래스 내에서만 객체를 생성할 수 있도록 제한할 수 있습니다.*/
class BoardNotFoundException private constructor(errorCode: ErrorCode) : CustomException(errorCode) {

    companion object {
        val CODE : BoardErrorCode = BoardErrorCode.BOARD_NOT_FOUND
    }

    constructor() : this(CODE)
}