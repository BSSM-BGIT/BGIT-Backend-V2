package com.bssm.bgitv2.domain.github.presentation.dto.res

import com.bssm.bgitv2.domain.github.domain.Github

/**
 * @Created by 최원용 on 2022. 12. 14.
 * @author 최원용
 * @version 2.0.0
 */

class GithubProfile(
        private var gitId: String
) {

    fun toEntity(): Github {
        return Github(
                githubId = gitId,
                githubImg = null,
                githubMessage = null,
                commits = null
        )
    }
}