package com.bssm.bgitv2.domain.github.presentation

import com.bssm.bgitv2.domain.github.presentation.dto.res.GithubResponse
import com.bssm.bgitv2.domain.github.service.GithubService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @Created by 최원용 on 2022. 12. 22.
 * @author 최원용
 * @version 2.0.0
 */

@RequestMapping("/github")
@RestController
class GithubController(
        private val githubService: GithubService
) {

    @GetMapping("/{id}")
    fun getDetail(@PathVariable id: Long): GithubResponse {
        return githubService.getDetail(id);
    }
}