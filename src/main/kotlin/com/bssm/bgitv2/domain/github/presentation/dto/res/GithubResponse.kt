package com.bssm.bgitv2.domain.github.presentation.dto.res

import com.bssm.bgitv2.domain.github.domain.Github

/**
 * @Created by 최원용 on 2022. 12. 22.
 * @author 최원용
 * @version 2.0.0
 */

class GithubResponse(
    val github: Github
) {

    val id: Long = github.id
    val commits: Long? = github.commits
    val githubId: String = github.githubId
    val githubImg: String? = github.githubImg
    val githubMessage: String? = github.githubMessage
    val userId: Long = github.user!!.id

}