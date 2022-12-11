package com.bssm.bgitv2.domain.user.domain.repo

import com.bssm.bgitv2.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @Created by 최원용 on 2022. 12. 11.
 * @author 최원용
 * @version 2.0.0
 */
interface UserRepository: JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
}