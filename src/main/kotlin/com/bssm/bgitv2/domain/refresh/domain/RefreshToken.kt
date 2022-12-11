package com.bssm.bgitv2.domain.refresh.domain

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */

@RedisHash
class RefreshToken(
        @Id
        private var id: String,

        @Indexed
        private var token: String,

        private var role: String,

        @TimeToLive
        private var ttl: Long
) {

    fun update(token: String, ttl: Long): RefreshToken {
        this.token = token
        this.ttl = ttl
        return this
    }
}