package com.bssm.bgitv2.global.error

/**
 * @Created by 최원용 on 2022. 12. 11.
 * @author 최원용
 * @version 2.0.0
 */
class ErrorResponse(
        private val status: Int,
        private val code: String,
        private val message: String
) {

    override fun toString(): String {
        return "{\n" +
                "\t\"status\": " + status +
                ",\t\"code\": \"" + code + '\"' +
                ",\n\t\"message\": \"" + message + '\"' +
                "\n}";
    }
}