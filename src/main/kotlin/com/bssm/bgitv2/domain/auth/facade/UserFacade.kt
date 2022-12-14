package com.bssm.bgitv2.domain.auth.facade

import com.bssm.bgitv2.domain.user.domain.User
import com.bssm.bgitv2.domain.user.domain.repo.UserRepository
import com.bssm.bgitv2.domain.user.domain.type.Authority
import com.bssm.bgitv2.domain.user.exception.UserNotLoginException
import com.bssm.bgitv2.global.security.util.SecurityUtil
import leehj050211.bsmOauth.dto.response.BsmResourceResponse
import leehj050211.bsmOauth.dto.response.BsmStudentResponse
import leehj050211.bsmOauth.dto.response.BsmTeacherResponse
import leehj050211.bsmOauth.type.BsmAuthUserRole.*
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.security.Security

/**
 * @Created by 최원용 on 2022. 12. 12.
 * @author 최원용
 * @version 2.0.0
 */

@Component
class UserFacade(
        private val userRepository: UserRepository
) {

    fun createUser(user: User): User {
        return userRepository.save(user);
    }

    private fun findByEmail(email: String): User? {
        return userRepository.findByEmail(email)
    }

    fun getCurrentUser(): User {
        println("email:" + SecurityUtil.getCurrentUser().username)
        return findByEmail(SecurityUtil.getCurrentUser().username) ?: throw UserNotLoginException()
    }

    fun getAndUpdateOrElseSignUp(resource: BsmResourceResponse, token: String): User {
        val user: User = findByEmail(resource.email) ?: return isNotNullOrElseSignUp(resource, token)

        return if (resource.role == STUDENT) {
            bsmUserUpdate(user, resource);
        } else user;
    }

    private fun isNotNullOrElseSignUp(resource: BsmResourceResponse, token: String): User {
        return if (resource.role == STUDENT) {
            bsmSignup(resource, token);
        } else {
            bsmTeacherSignup(resource, token);
        }
    }

    @Transactional
    fun bsmSignup(dto: BsmResourceResponse, bsmToken: String): User {
        val student: BsmStudentResponse = dto.student
        val user = User(
                email = dto.email,
                name = student.name,
                grade = student.grade,
                classNo = student.classNo,
                studentNo = student.studentNo,
                authority = Authority.USER
//                imaginary(Imaginary.REAL_NUMBER)
        )
        createUser(user)
        return createUser(user)
    }

    @Transactional
    fun bsmTeacherSignup(dto: BsmResourceResponse, bsmToken: String): User {
        val teacher: BsmTeacherResponse = dto.teacher
        val user = User(
                email = dto.email,
                name = teacher.name,
                grade = null,
                classNo = null,
                studentNo = null,
                authority = Authority.USER
//                .imaginary(Imaginary.REAL_NUMBER)
        )
        return createUser(user)
    }

    @Transactional
    fun bsmUserUpdate(user: User, resource: BsmResourceResponse): User {
        val student: BsmStudentResponse = resource.student
        user.updateName(student.name)
        user.updateStudentGrade(student.grade)
        user.updateStudentClassNo(student.classNo)
        user.updateStudentNo(student.studentNo)
        return userRepository.save(user)
    }
}