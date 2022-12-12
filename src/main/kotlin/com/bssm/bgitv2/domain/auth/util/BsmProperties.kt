package com.bssm.bgitv2.domain.auth.util

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */

@ConstructorBinding
@ConfigurationProperties(prefix = "spring.oauth.bsm.client")
class BsmProperties(
        val id: String,
        val secretKey: String
) {

}