package com.bssm.bgitv2.global.security.jwt.auth

import com.bssm.bgitv2.global.auth.AuthDetailsService
import com.bssm.bgitv2.global.security.exception.InvalidJwtException
import com.bssm.bgitv2.global.security.jwt.JwtConstants.*
import com.bssm.bgitv2.global.security.jwt.JwtProperties
import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */

@Component
class JwtAuth(
        private val authDetailsService: AuthDetailsService,
        private val userDetailsService: UserDetailsService,
        private val jwtProperties: JwtProperties
) {

    fun authentication(token: String): Authentication {
        val body: Claims = getJws(token).body
        if (!isNotRefreshToken(token)) {
            throw InvalidJwtException()
        }
        val userDetails: UserDetails = getDetails(body)
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    fun getJws(token: String): Jws<Claims> {
        return try {
            Jwts.parser().setSigningKey(jwtProperties.secret)
                    .parseClaimsJws(token)
        } catch (e: ExpiredJwtException) {
            throw com.bssm.bgitv2.global.security.exception.ExpiredJwtException()
        } catch (e: Exception) {
            throw InvalidJwtException()
        }
    }

    private fun isNotRefreshToken(token: String): Boolean {
        return REFRESH_KEY.message != getJws(token).header[TYPE.message].toString()
    }

    private fun getDetails(body: Claims): UserDetails {
        return if (USER_ROLE.message == body[ROLE.message].toString()
                || ADMIN_ROLE.message == body[ROLE.message].toString()) {
            authDetailsService
                    .loadUserByUsername(body.subject)
        } else userDetailsService
                .loadUserByUsername(body.subject)
    }
}