package com.bssm.bgitv2.domain.refresh.domain.repo

import com.bssm.bgitv2.domain.refresh.domain.RefreshToken
import org.springframework.data.repository.CrudRepository

/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */
interface RefreshTokenRepository: CrudRepository<RefreshToken, Long> {
}