package com.bssm.bgitv2.global.security.util

import com.bssm.bgitv2.global.auth.AuthDetails
import org.springframework.security.core.context.SecurityContextHolder


/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */
class SecurityUtil {
    companion object {
        fun getCurrentUser(): AuthDetails {
            return SecurityContextHolder.getContext()
                    .authentication
                    .principal as AuthDetails
        }
    }
}