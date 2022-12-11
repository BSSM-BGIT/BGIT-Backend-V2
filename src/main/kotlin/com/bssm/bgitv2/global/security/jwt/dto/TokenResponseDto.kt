package com.bssm.bgitv2.global.security.jwt.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.ZonedDateTime

/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */

class TokenResponseDto(
        private val accessToken: String,
        private val refreshToken: String,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private val expiredAt: ZonedDateTime
) {
}