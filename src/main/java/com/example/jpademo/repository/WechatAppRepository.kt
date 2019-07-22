package com.example.jpademo.repository

import com.example.jpademo.entity.WechatApp
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Classname WechatAppRepository
 * Description
 * Date 2019-06-25 18:03
 * Created by Wang jun gang
 */
interface WechatAppRepository : JpaRepository<WechatApp, String>
