package com.example.jpademo.service

import cn.jgayb.dao.utils.jpa.BaseService
import com.example.jpademo.entity.User
import com.example.jpademo.repository.UserRepository

/**
 * Classname UserService
 * Description
 * Date 2019-06-27 13:21
 * Created by Wang jun gang
 */
interface UserService : BaseService<User, String, UserRepository>