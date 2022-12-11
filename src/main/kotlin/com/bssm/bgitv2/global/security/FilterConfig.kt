package com.bssm.bgitv2.global.security

import com.bssm.bgitv2.global.error.ExceptionFilter
import com.bssm.bgitv2.global.security.jwt.JwtProvider
import com.bssm.bgitv2.global.security.jwt.auth.JwtAuth
import com.bssm.bgitv2.global.security.jwt.auth.JwtFilter
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */
class FilterConfig(
        private val jwtProvider: JwtProvider,
        private val jwtAuth: JwtAuth
): SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        val jwtFilter = JwtFilter(jwtProvider, jwtAuth)
        val globalExceptionFilter = ExceptionFilter()
        builder.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(globalExceptionFilter, JwtFilter::class.java)
    }

}