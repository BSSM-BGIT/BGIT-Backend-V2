package com.bssm.bgitv2.global.auth

import com.bssm.bgitv2.domain.user.domain.repo.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.lang.Exception
import java.lang.IllegalStateException

/**
 * @Created by 최원용 on 2022. 12. 11.
 * @author 최원용
 * @version 2.0.0
 */

@Service
class AuthDetailsService(
        private val userRepository: UserRepository
): UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails {
        val user = (userRepository.findByEmail(email)
                ?: throw IllegalStateException())
        return AuthDetails(user)
    }

}