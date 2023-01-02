package com.bssm.bgitv2.global.security

import com.bssm.bgitv2.domain.auth.facade.UserFacade
import com.bssm.bgitv2.domain.github.domain.Github
import com.bssm.bgitv2.domain.user.domain.User
 import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.user.DefaultOAuth2User
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service
import java.util.*
import javax.servlet.http.HttpSession


/**
 * @Created by 최원용 on 2022. 12. 14.
 * @author 최원용
 * @version 2.0.0
 */

@Service
class CustomOAuth2UserService(
        private val userFacade: UserFacade,
        private val session: HttpSession
) : OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    override fun loadUser(userRequest: OAuth2UserRequest?): OAuth2User {
        val service = DefaultOAuth2UserService()
        val oAuth2User = service.loadUser(userRequest)

        val user: User = saveOrUpdate(oAuth2User)

        session.setAttribute("oAuthToken", userRequest!!.accessToken.tokenValue)

        return DefaultOAuth2User(
                Collections.singleton(SimpleGrantedAuthority(user.authority.name)),
                oAuth2User.attributes, "login")
    }

    fun saveOrUpdate(oAuth2User: OAuth2User): User {
        val github: Github = Github(
                githubId = oAuth2User.attributes["login"] as String,
                githubImg = null,
                githubMessage = null,
                commits = null
        )

        val user = userFacade.getCurrentUser();
        github.confirmUser(user)

        return user
    }

}