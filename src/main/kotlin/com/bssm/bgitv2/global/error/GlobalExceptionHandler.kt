package com.bssm.bgitv2.global.error

import com.bssm.bgitv2.global.error.exception.BgitException
import com.bssm.bgitv2.global.error.exception.ErrorCode
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.validation.BindException;
import javax.validation.ConstraintViolationException

/**
 * @Created by 최원용 on 2022. 12. 11.
 * @author 최원용
 * @version 2.0.0
 */

@RestControllerAdvice
class GlobalExceptionHandler {

    private val log = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(BgitException::class)
    fun handleGlobal(e: BgitException): Any? {
        val errorCode: ErrorCode = e.errorCode
        log.error(
                ((("\n" + "{\n" +
                        "\t\"status\": " + errorCode.status() + '\"') +
                        ",\n\t\"code\": \"" + errorCode.code() + '\"') +
                        ",\n\t\"message\": \"" + errorCode.message() + '\"') +
                        "\n}"
        )
        return ResponseEntity<Any?>(
                ErrorResponse(
                        errorCode.status(),
                        errorCode.code(),
                        errorCode.message()),
                HttpStatus.valueOf(errorCode.status())
        )
    }

    @ExceptionHandler(BindException::class)
    fun bindException(e: BindException): ResponseEntity<*>? {
        val errorMap: MutableMap<String, String?> = HashMap()
        for (error in e.fieldErrors) {
            errorMap[error.field] = error.defaultMessage
            log.error(error.toString())
            log.error(error.defaultMessage)
        }
        return ResponseEntity<Map<String, String?>>(errorMap, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun constraintViolationException(e: ConstraintViolationException): ResponseEntity<*>? {
        val errorMap: MutableMap<String, String> = HashMap()
        for (error in e.constraintViolations) {
            errorMap["constraint error"] = error.message
            log.error(error.toString())
        }
        return ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST)
    }
}