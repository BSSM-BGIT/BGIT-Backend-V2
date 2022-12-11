package com.bssm.bgitv2.global.security.jwt.auth

import com.bssm.bgitv2.global.security.jwt.JwtProvider
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */
class JwtFilter(
        private val jwtProvider: JwtProvider,
        private val jwtAuth: JwtAuth
): OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val bearer = jwtProvider.resolveToken(request)
        isBearerNotNullSetContextHolderToAuthentication(bearer)
        filterChain.doFilter(request, response)
    }

    private fun isBearerNotNullSetContextHolderToAuthentication(bearer: String?) {
        if (bearer != null) {
            val authentication: Authentication = jwtAuth.authentication(bearer)
            SecurityContextHolder.getContext().authentication = authentication
        }
    }

}