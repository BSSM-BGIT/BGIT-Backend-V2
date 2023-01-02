package com.bssm.bgitv2.global.error.exception

import com.fasterxml.jackson.annotation.JsonFormat

/**
 * @Created by 최원용 on 2022. 12. 11.
 * @author 최원용
 * @version 2.0.0
 */

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum class ErrorCode(
        private val status: Int,
        private val code: String,
        private val message: String
) {
    PASSWORD_NOT_MATCH(400, "AUTH-400-1", "Password Not Match"),
    SAVE_IMAGE_FAILED(400, "COMMON-400-1", "Save Image Failed"),
    IMAGE_VALUE_NOT_FOUND(400, "COMMON-404-1", "Image Value Not Found"),

    EXPIRED_JWT(401, "COMMON-401-1", "Expired Jwt"),
    INVALID_JWT(401, "COMMON-401-2", "Invalid Jwt"),
    BSM_AUTH_INVALID_CLIENT(401, "BSM-401-1", "Invalid BSM Auth Invalid Client"),
    PASSWORD_MISMATCH(401, "AUTH-401-1", "Password Mismatch"),

    USER_NOT_LOGIN(403, "USER-403-1", "User Not Login"),
    FORBIDDEN(403, "COMMON-403-1", "Forbidden"),
    DONT_ACCESS_OTHER_PLAN(403, "PLAN-403-1", "Don't Access Other Plan"),

    USER_NOT_FOUND(404, "USER-404-1", "User Not Found"),
    ADMIN_NOT_FOUND(404, "ADMIN-404-1", "Admin Not Found"),
    CATEGORY_NOT_FOUND(404, "CATEGORY-404-1", "Category Not Found"),
    CREDENTIALS_NOT_FOUND(404, "USER-404-3", "Credentials Not Found"),
    REFRESH_TOKEN_NOT_FOUND(404, "AUTH-404-1", "Refresh Token Not Found"),
    AUTH_ID_NOT_FOUND(404, "AUTH-404-4", "AuthId(Username) Not Found"),

    ALREADY_EXISTS_USER(409, "USER-409-1", "User Already Exists"),
    ALREADY_EXISTS_JOINED(409, "USER-409-2", "Already Joined"),

    REDIS_TRANSACTION_EXCEPTION(500, "REDIS-500-1", "Cannot Read Cache From Redis"),
    INTERNAL_SERVER_ERROR(500, "SERVER-500-1", "Internal Server Error");
    fun status(): Int = status
    fun code(): String = code
    fun message(): String = message
}