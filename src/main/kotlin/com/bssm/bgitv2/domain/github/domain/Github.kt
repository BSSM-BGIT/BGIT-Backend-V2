package com.bssm.bgitv2.domain.github.domain

import com.bssm.bgitv2.domain.user.domain.User
import com.bssm.bgitv2.global.entity.BaseTimeEntity
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */

@Entity
@DynamicUpdate
@DynamicInsert
class Github(
        var githubId: String,
        var githubImg: String?,
        var githubMessage: String?,
        var commits: Long?,
): BaseTimeEntity() {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User? = null

    fun confirmUser(user: User) {
        this.user = user
        user.updateGithub(this)
    }
}