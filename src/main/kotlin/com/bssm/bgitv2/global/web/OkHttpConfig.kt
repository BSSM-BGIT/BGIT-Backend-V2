package com.bssm.bgitv2.global.web

import okhttp3.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @Created by 최원용 on 2022. 12. 14.
 * @author 최원용
 * @version 2.0.0
 */

@Configuration
internal class OkHttpConfig {
    @Bean("okHttpClient")
    fun okHttpClient(): OkHttpClient {
        return OkHttpClient()
    }
}