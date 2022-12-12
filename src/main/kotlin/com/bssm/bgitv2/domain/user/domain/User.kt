package com.bssm.bgitv2.domain.user.domain

import com.bssm.bgitv2.domain.user.domain.type.Authority
import com.bssm.bgitv2.global.entity.BaseTimeEntity
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

/**
 * @Created by 최원용 on 2022. 12. 11.
 * @author 최원용
 * @version 2.0.0
 */

@Entity
@DynamicInsert
@DynamicUpdate
class User(
        var email: String,
        var name: String,
        var grade: Int?,
        var classNo: Int?,
        var studentNo: Int?,
//        var bsmToken: String,
        @Enumerated(EnumType.STRING)
        var authority: Authority,
): BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L;

//    var password: String? = null

    fun updateStudentGrade(grade: Int) {
        this.grade = grade
    }

    fun updateName(name: String) {
        this.name = name
    }

    fun updateStudentClassNo(classNo: Int) {
        this.classNo = classNo
    }

    fun updateStudentNo(studentNo: Int) {
        this.studentNo = studentNo
    }
}