package com.bssm.bgitv2.domain.auth.service

import com.bssm.bgitv2.domain.auth.exception.BsmAuthInvalidClientException
import com.bssm.bgitv2.domain.auth.facade.UserFacade
import com.bssm.bgitv2.domain.user.domain.User
import com.bssm.bgitv2.global.annotation.ServiceWithTransactionalReadOnly
import com.bssm.bgitv2.global.security.jwt.JwtProvider
import com.bssm.bgitv2.global.security.jwt.dto.TokenResponseDto
import leehj050211.bsmOauth.BsmOauth
import leehj050211.bsmOauth.dto.response.BsmResourceResponse
import leehj050211.bsmOauth.exceptions.BsmAuthCodeNotFoundException
import org.springframework.transaction.annotation.Transactional

/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */

@ServiceWithTransactionalReadOnly
class LoginService(
        private val userFacade: UserFacade,
        private val bsmOauth: BsmOauth,
        private val jwtProvider: JwtProvider
) {

    @Throws(Exception::class)
    @Transactional
    fun bsmLogin(authCode: String): TokenResponseDto {
        val user: User = bsmOauth(authCode);
        return jwtProvider.generateToken(user.email, user.authority.name);
    }

    @Throws(Exception::class)
    private fun bsmOauth(authCode: String): User {
        val token: String
        val resource: BsmResourceResponse

        try {
            token = bsmOauth.getToken(authCode)
            resource = bsmOauth.getResource(token)
        } catch (e: BsmAuthCodeNotFoundException) {
            throw BsmAuthInvalidClientException()
        } catch (e: BsmAuthInvalidClientException) {
            throw BsmAuthInvalidClientException()
        }

        return userFacade.getAndUpdateOrElseSignUp(resource, token);
    }

}