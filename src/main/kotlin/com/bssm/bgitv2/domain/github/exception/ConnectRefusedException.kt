package com.bssm.bgitv2.domain.github.exception

import com.bssm.bgitv2.global.error.exception.BgitException
import com.bssm.bgitv2.global.error.exception.ErrorCode

/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */
class ConnectRefusedException: BgitException(ErrorCode.CONNECTION_REFUSED) {
}