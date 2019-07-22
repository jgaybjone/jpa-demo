package com.example.jpademo.service

import cn.jgayb.dao.utils.jpa.BaseService
import com.example.jpademo.entity.WechatApp
import com.example.jpademo.repository.WechatAppRepository
import java.util.*

/**
 * Classname WechatAppService
 * Description
 * Date 2019-06-27 13:24
 * Created by Wang jun gang
 */
interface WechatAppService : BaseService<WechatApp, String, WechatAppRepository> {

    fun findByIdLazy(id: String): Optional<WechatApp>

    fun findByIdEager(id: String): Optional<WechatApp>
}