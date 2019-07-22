package com.example.jpademo.entity

import com.example.jpademo.annotation.AllOpenAndNoArg
import javax.persistence.*

/**
 * Classname WechatAppRate
 * Description
 * Date 2019-06-25 17:18
 * Created by Wang jun gang
 */
@Entity
@Table(name = "wechat_app_rate")
@AllOpenAndNoArg
data class WechatAppRate(
        @Id
        @Column(name = "id", nullable = false)
        private val id: Int = 0,

        @Basic
        @Column(name = "wechat_app_id", nullable = false, length = 20)
        private val wechatAppId: String? = null,

        @Basic
        @Column(name = "hit", nullable = true)
        private val hit: Int? = null
)
