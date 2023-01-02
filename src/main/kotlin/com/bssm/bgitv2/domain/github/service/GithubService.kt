package com.bssm.bgitv2.domain.github.service

import com.bssm.bgitv2.domain.github.facade.GithubFacade
import com.bssm.bgitv2.domain.github.presentation.dto.res.GithubResponse
import com.bssm.bgitv2.global.annotation.ServiceWithTransactionalReadOnly

/**
 * @Created by 최원용 on 2022. 12. 22.
 * @author 최원용
 * @version 2.0.0
 */

@ServiceWithTransactionalReadOnly
class GithubService(
        private val githubFacade: GithubFacade
) {

    fun getDetail(id: Long): GithubResponse {
        return GithubResponse(githubFacade.searchGithubDetails(id)!!);
    }
}