package com.bssm.bgitv2.global.error

import com.bssm.bgitv2.global.error.exception.BgitException
import com.bssm.bgitv2.global.error.exception.ErrorCode
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @Created by 최원용 on 2022. 12. 11.
 * @author 최원용
 * @version 2.0.0
 */
class ExceptionFilter: OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: BgitException) {
            writerErrorCode(response, e.errorCode)
        } catch (e: Exception) {
            e.printStackTrace();
            writerErrorCode(response, ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    private fun writerErrorCode(response: HttpServletResponse, errorCode: ErrorCode) {
        val errorResponse: ErrorResponse = ErrorResponse(
                errorCode.status(),
                errorCode.code(),
                errorCode.message()
        )

        response.status = errorCode.status();
        response.characterEncoding = "UTF-8";
        response.contentType = MediaType.APPLICATION_JSON_VALUE;
        response.writer.write(errorResponse.toString());
    }
}