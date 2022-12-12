package com.bssm.bgitv2.global.security

import com.bssm.bgitv2.global.error.CustomAuthenticationEntryPoint
import com.bssm.bgitv2.global.security.jwt.JwtProvider
import com.bssm.bgitv2.global.security.jwt.auth.JwtAuth
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsUtils
import java.lang.Exception
import kotlin.jvm.Throws

@Configuration
@EnableWebSecurity
class SecurityConfig(
        private val jwtProvider: JwtProvider,
        private val jwtAuth: JwtAuth,
        private val objectMapper: ObjectMapper
) {
    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain? {
        http
                .csrf().disable()
                .formLogin().disable()
                .cors()

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .antMatchers(HttpMethod.POST, "/login/**").permitAll()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(CustomAuthenticationEntryPoint(objectMapper))

                .and().apply(FilterConfig(jwtProvider, jwtAuth));

        return http.build();
    }
}