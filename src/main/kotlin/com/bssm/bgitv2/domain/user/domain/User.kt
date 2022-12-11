package com.bssm.bgitv2.domain.user.domain

import com.bssm.bgitv2.domain.user.domain.type.Authority
import com.bssm.bgitv2.global.entity.BaseTimeEntity
import lombok.Getter
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * @Created by 최원용 on 2022. 12. 11.
 * @author 최원용
 * @version 2.0.0
 */

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
class User(
        var email: String,
        var name: String,
        var password: String,
        var authority: Authority,
): BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L;

}