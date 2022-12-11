package com.bssm.bgitv2.global.entity

import lombok.Getter
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDate
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

/**
 * @Created by 최원용 on 2022. 12. 11.
 * @author 최원용
 * @version 2.0.0
 */

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
class BaseTimeEntity {

    @CreatedDate
    val createdAt: LocalDate = LocalDate.now();

    @LastModifiedDate
    val updatedAt: LocalDate = LocalDate.now();

}