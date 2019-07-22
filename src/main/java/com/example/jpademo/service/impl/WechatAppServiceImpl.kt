package com.example.jpademo.service.impl

import com.example.jpademo.entity.WechatApp
import com.example.jpademo.repository.WechatAppRepository
import com.example.jpademo.service.WechatAppService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class WechatAppServiceImpl : WechatAppService {

    val log = LoggerFactory.getLogger(this.javaClass)

    override fun getRepository(): WechatAppRepository {
        return this.wechatAppRepository
    }

    @Autowired
    lateinit var wechatAppRepository: WechatAppRepository

    @Transactional
    override fun findByIdEager(id: String): Optional<WechatApp> {
        return crudAndFunction {
            val optional = it.findById(id)
            optional.ifPresent { o ->
                o.qrcodes?.size
            }
            return@crudAndFunction optional
        }
    }

    @Transactional
    override fun findByIdLazy(id: String): Optional<WechatApp> {
        return crudAndFunction {
            val optional = it.findById(id)
            optional.ifPresent { o ->
                o.qrcodes = null
            }
            return@crudAndFunction optional
        }
    }

}