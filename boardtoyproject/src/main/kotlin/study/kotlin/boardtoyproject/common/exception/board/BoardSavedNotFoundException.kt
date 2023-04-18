package study.kotlin.boardtoyproject.common.exception.board

import study.kotlin.boardtoyproject.common.exception.CustomException
import study.kotlin.boardtoyproject.common.exception.ErrorCode

class BoardSavedNotFoundException private constructor(errorCode: ErrorCode) : CustomException(errorCode) {

    companion object{
        val CODE = BoardErrorCode.SAVED_BOARD_NOT_FOUND
    }
    constructor() : this(CODE)
}