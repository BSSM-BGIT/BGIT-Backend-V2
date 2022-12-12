package com.bssm.bgitv2.domain.auth.presentation.controller

import com.bssm.bgitv2.domain.auth.service.LoginService
import com.bssm.bgitv2.global.security.jwt.dto.TokenResponseDto
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */

@Validated
@RequestMapping("/login")
@RestController
class LoginController(
        private val loginService: LoginService
) {

    @PostMapping("/{authCode}")
    fun login(@PathVariable authCode: String): TokenResponseDto {
        return loginService.bsmLogin(authCode)
    }

}