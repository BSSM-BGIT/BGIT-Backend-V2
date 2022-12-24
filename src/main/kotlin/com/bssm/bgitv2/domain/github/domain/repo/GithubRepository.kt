package com.bssm.bgitv2.domain.github.domain.repo

import com.bssm.bgitv2.domain.github.domain.Github
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */
interface GithubRepository: JpaRepository<Github, Long> {
}