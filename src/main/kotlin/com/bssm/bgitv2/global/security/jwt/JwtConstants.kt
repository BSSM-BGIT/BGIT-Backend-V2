package com.bssm.bgitv2.global.security.jwt

/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */
enum class JwtConstants(
        val message: String
) {

    ACCESS_KEY("access_token"),
    REFRESH_KEY("refresh_token"),
    EMPTY(" "),
    TYPE("type"), ROLE("role"),
    EMAIL("email"),
    USER_ROLE("USER"),
    ADMIN_ROLE("ADMIN"),
    SUPER_ADMIN_ROLE("SUPER_ADMIN")

}