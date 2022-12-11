package com.bssm.bgitv2.global.security.jwt

import lombok.Getter
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */

@ConstructorBinding
@ConfigurationProperties(prefix = "auth.jwt")
class JwtProperties(
        val header: String,
        val secret: String,
        val accessExp: Long,
        val refreshExp: Long,
        val prefix: String
) {

}