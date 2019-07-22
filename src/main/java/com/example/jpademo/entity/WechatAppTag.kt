package com.example.jpademo.entity

import com.example.jpademo.annotation.AllOpenAndNoArg
import javax.persistence.*

/**
 * Classname WechatAppTag
 * Description
 * Date 2019-06-25 17:18
 * Created by Wang jun gang
 */
@Entity
@Table(name = "wechat_app_tag")
@AllOpenAndNoArg
data
class WechatAppTag(
        @Id
        @Column(name = "id", nullable = false)
        var id: Int = 0,
        @Basic
        @Column(name = "wechat_app_id", nullable = true, length = 30)
        var wechatAppId: String? = null,
        @Basic
        @Column(name = "tag_id", nullable = true)
        var tagId: Int? = null
)
