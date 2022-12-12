package com.bssm.bgitv2.domain.user.exception

import com.bssm.bgitv2.global.error.exception.BgitException
import com.bssm.bgitv2.global.error.exception.ErrorCode

/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */
class UserNotLoginException: BgitException(ErrorCode.USER_NOT_LOGIN) {
}