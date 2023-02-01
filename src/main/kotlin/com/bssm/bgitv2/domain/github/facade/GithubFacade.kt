package com.bssm.bgitv2.domain.github.facade

import com.bssm.bgitv2.domain.github.domain.Github
import com.bssm.bgitv2.domain.github.domain.repo.GithubRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

/**
 * @Created by 최원용 on 2022. 12. 22.
 * @author 최원용
 * @version 2.0.0
 */

@Component
class GithubFacade(
        private val githubRepository: GithubRepository
) {

    fun searchGithubDetails(id: Long): Github? {
        return githubRepository.findByIdOrNull(id);
    }

    fun getAll(): List<Github> {
        return githubRepository.findAll();
    }
}