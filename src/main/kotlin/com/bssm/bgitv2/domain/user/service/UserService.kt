package com.bssm.bgitv2.domain.user.service

import com.bssm.bgitv2.domain.auth.facade.UserFacade
import com.bssm.bgitv2.domain.user.presentation.dto.res.UserResponseDto
import com.bssm.bgitv2.global.annotation.ServiceWithTransactionalReadOnly

/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */

@ServiceWithTransactionalReadOnly
class UserService(
        private val userFacade: UserFacade
) {

    fun getCurrentUser(): UserResponseDto {
        return UserResponseDto(userFacade.getCurrentUser())
    }
}