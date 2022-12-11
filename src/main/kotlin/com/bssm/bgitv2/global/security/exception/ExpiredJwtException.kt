package com.bssm.bgitv2.global.security.exception

import com.bssm.bgitv2.global.error.exception.BgitException
import com.bssm.bgitv2.global.error.exception.ErrorCode


/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */
class ExpiredJwtException : BgitException(ErrorCode.EXPIRED_JWT)