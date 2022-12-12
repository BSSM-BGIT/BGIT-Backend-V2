package com.bssm.bgitv2.global.annotation

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */

@Target(AnnotationTarget.CLASS)
@Retention
@Transactional(readOnly = true)
@Service
annotation class ServiceWithTransactionalReadOnly()
