package com.bssm.bgitv2.domain.github.presentation.dto.res

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @Created by 최원용 on 2022. 12. 14.
 * @author 최원용
 * @version 2.0.0
 */

class OauthTokenResponse (
        accessToken: String,
        scope: String,
        tokenType: String
) {
    @JsonProperty("access_token")
    val accessToken: String
    val scope: String

    @JsonProperty("token_type")
    val tokenType: String

    init {
        this.accessToken = accessToken
        this.scope = scope
        this.tokenType = tokenType
    }
}
