package study.kotlin.boardtoyproject.common.exception.board

import study.kotlin.boardtoyproject.common.exception.CustomException
import study.kotlin.boardtoyproject.common.exception.ErrorCode

// 현재 요청사항을 찾지 못했습니다. id를 다시 확인해주세요.
class BoardResourceNotFoundException private constructor(errorCode: ErrorCode) : CustomException(errorCode){
    companion object {
        val CODE = BoardErrorCode.RESOURCE_NOT_FOUND_EXCEPTION
    }
    constructor() : this(CODE)
}