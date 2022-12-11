package com.bssm.bgitv2.domain.auth.domain

import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;

/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */

@RedisHash
class Email(
        @Id
        private var id: Long,

        @Indexed
        private var email: String
) {
}