package com.bssm.bgitv2.global.error.exception

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.RequiredArgsConstructor
import java.lang.RuntimeException

/**
 * @Created by 최원용 on 2022. 12. 11.
 * @author 최원용
 * @version 2.0.0
 */

open class BgitException(
        val errorCode: ErrorCode
): RuntimeException() {

}