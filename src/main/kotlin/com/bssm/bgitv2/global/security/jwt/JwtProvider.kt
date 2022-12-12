package com.bssm.bgitv2.global.security.jwt

import com.bssm.bgitv2.domain.auth.domain.Email
import com.bssm.bgitv2.domain.auth.domain.repo.EmailRepository
import com.bssm.bgitv2.domain.refresh.domain.RefreshToken
import com.bssm.bgitv2.domain.refresh.domain.repo.RefreshTokenRepository
import com.bssm.bgitv2.global.security.jwt.JwtConstants.*
import com.bssm.bgitv2.global.security.jwt.auth.JwtAuth
import com.bssm.bgitv2.global.security.jwt.dto.TokenResponseDto
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.time.ZonedDateTime
import java.util.*
import javax.servlet.http.HttpServletRequest


/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */

@Component
class JwtProvider(
        private val jwtProperties: JwtProperties,
        private val refreshTokenRepository: RefreshTokenRepository,
        private val emailRepository: EmailRepository,
        private val jwtAuth: JwtAuth
) {

    fun generateToken(email: String, role: String): TokenResponseDto {
        val accessToken: String = jwtProperties.prefix + EMPTY.message +
                generateToken(email, role, ACCESS_KEY.message, jwtProperties.accessExp)
        println("accessToken = $accessToken")
        val refreshToken = jwtProperties.prefix + EMPTY.message + generateToken(email, role, ACCESS_KEY.message, jwtProperties.refreshExp)
        println("refreshToken = $refreshToken")

        refreshTokenRepository.save(RefreshToken(
                email,
                refreshToken,
                role,
                jwtProperties.refreshExp * 1000)
        )

        return TokenResponseDto(accessToken, refreshToken, getExpiredTime())
    }

    private fun generateToken(email: String, role: String, type: String, exp: Long): String? {
        return Jwts.builder()
                .setSubject(email)
                .setHeaderParam(TYPE.message, type)
                .claim(ROLE.message, role)
                .claim(EMAIL.message, email)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.secret)
                .setExpiration(
                        Date(System.currentTimeMillis() + exp * 1000)
                )
                .setIssuedAt(Date())
                .compact()
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearer = request.getHeader(jwtProperties.header)
        return parseToken(bearer)
    }

    fun parseToken(bearerToken: String?): String? {
        if (bearerToken != null && bearerToken.startsWith(jwtProperties.prefix)) {
            val token = bearerToken.replace(jwtProperties.prefix, "").trim { it <= ' ' }
            ifAuthIdIsPresentThrowException(token)
            return token
        }
        return null
    }

    private fun ifAuthIdIsPresentThrowException(bearerToken: String) {
        val body: Claims = jwtAuth.getJws(bearerToken).body
        val tokenAuthId = body[EMAIL.message].toString()
        val email: Email? = emailRepository.findByEmail(tokenAuthId)
        if (email != null) {
            throw com.bssm.bgitv2.global.security.exception.ExpiredJwtException()
        }
    }

    fun getExpiredTime(): ZonedDateTime {
        return ZonedDateTime.now().plusSeconds(jwtProperties.refreshExp)
    }

}