package com.bssm.bgitv2.global.security

import com.bssm.bgitv2.domain.auth.util.BsmProperties
import leehj050211.bsmOauth.BsmOauth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */

@Configuration
class BsmOauthConfig(
        private val bsmProperties: BsmProperties
) {
    @Bean
    fun bsmOauth(): BsmOauth {
        return BsmOauth(bsmProperties.id, bsmProperties.secretKey)
    }
}