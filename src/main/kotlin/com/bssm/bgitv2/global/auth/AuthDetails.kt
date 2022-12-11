package com.bssm.bgitv2.global.auth

import com.bssm.bgitv2.domain.user.domain.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

/**
 * @Created by 최원용 on 2022. 12. 11.
 * @author 최원용
 * @version 2.0.0
 */
class AuthDetails(
        private val user: User
): UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return Collections
                .singleton(SimpleGrantedAuthority(user.authority.name));
    }

    override fun getPassword(): String? {
        return null
    }

    override fun getUsername(): String {
        return user.name
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}