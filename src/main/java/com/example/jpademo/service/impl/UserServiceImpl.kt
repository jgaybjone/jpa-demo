package com.example.jpademo.service.impl

import com.example.jpademo.repository.UserRepository
import com.example.jpademo.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    val log = LoggerFactory.getLogger(this.javaClass)!!

    @Autowired
    lateinit var userRepository: UserRepository

    override fun getRepository(): UserRepository {
        return userRepository
    }

}