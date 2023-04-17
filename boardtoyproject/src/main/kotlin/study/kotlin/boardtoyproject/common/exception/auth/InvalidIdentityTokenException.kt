package study.kotlin.boardtoyproject.common.exception.auth

import study.kotlin.boardtoyproject.common.exception.CustomException

class InvalidIdentityTokenException private constructor(errorCode: AuthErrorCode) : CustomException(errorCode) {

    // static 선언할 때는 이와 같이 하는데,
    // 내부에서 선언된 CODE를
    companion object {
        private val CODE = AuthErrorCode.INVALID_IDENTITY_TOKEN
    }

    // this(code) : constructor(errorCode: AuthErrorCode)가 실행되고 CustomException에 있는 ErrorCode에 저장한다.
    constructor() : this(CODE)

}