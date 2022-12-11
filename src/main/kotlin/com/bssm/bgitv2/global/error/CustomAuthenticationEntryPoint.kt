package com.bssm.bgitv2.global.error

import com.bssm.bgitv2.global.error.exception.ErrorCode
import com.fasterxml.jackson.databind.ObjectMapper
import lombok.RequiredArgsConstructor
import org.springframework.http.MediaType
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @Created by 최원용 on 2022. 12. 11.
 * @author 최원용
 * @version 2.0.0
 */

@RequiredArgsConstructor
@Component
class CustomAuthenticationEntryPoint(
        private val objectMapper: ObjectMapper
): AuthenticationEntryPoint {

    override fun commence(request: HttpServletRequest?, response: HttpServletResponse?, authException: AuthenticationException?) {
        val errorCode: ErrorCode = ErrorCode.FORBIDDEN
        val errorResponseJson: String = objectMapper.writeValueAsString(
                ErrorResponse(errorCode.status(), errorCode.code(), errorCode.message()))

        response!!.status = errorCode.status()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(errorResponseJson)
    }
}