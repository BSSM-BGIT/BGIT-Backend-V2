package com.bssm.bgitv2.domain.user.presentation

import com.bssm.bgitv2.domain.user.presentation.dto.res.UserResponseDto
import com.bssm.bgitv2.domain.user.service.UserService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */

@Validated
@RequestMapping("/user")
@RestController
class UserController(
        private val userService: UserService
) {

    @GetMapping
    fun currentUserInfo(): UserResponseDto {
        return userService.getCurrentUser();
    }

}
