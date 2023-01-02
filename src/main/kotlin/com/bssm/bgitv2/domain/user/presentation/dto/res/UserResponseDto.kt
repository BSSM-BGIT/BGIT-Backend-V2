package com.bssm.bgitv2.domain.user.presentation.dto.res

import com.bssm.bgitv2.domain.user.domain.User

/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */

class UserResponseDto(
        private val user: User
) {
    val userId: Long = user.id
    val authority: String = user.authority.name
    val email: String = user.email
    val name: String = user.name
    val grade: Int? = user.grade
    val classNo: Int? = user.classNo
    val studentNo: Int? = user.studentNo
}