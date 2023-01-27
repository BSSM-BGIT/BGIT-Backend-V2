package com.bssm.bgitv2.domain.auth.exception

import com.bssm.bgitv2.global.error.exception.BgitException
import com.bssm.bgitv2.global.error.exception.ErrorCode

/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */
class BsmAuthInvalidClientException: BgitException(ErrorCode.BSM_AUTH_INVALID_CLIENT) {
}