@file:Suppress("SpringDataRepositoryMethodReturnTypeInspection")

package com.example.jpademo.repository

import com.example.jpademo.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

/**
 * Classname UserRepository
 * Description
 * Date 2019-06-25 17:26
 * Created by Wang jun gang
 */
@Repository
interface UserRepository : JpaRepository<User, String> {

    @Query(value = "select nickname from user u where u.id = :id", nativeQuery = true)
    fun findNicknameById(id: String): Optional<String>

    @Query(value = "select username from user u where u.id = :id", nativeQuery = true)
    fun findUsernameById(id: String): Optional<String>

}
