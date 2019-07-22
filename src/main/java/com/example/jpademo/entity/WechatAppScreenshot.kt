package com.example.jpademo.entity

import com.example.jpademo.annotation.AllOpenAndNoArg
import java.sql.Timestamp
import javax.persistence.*

/**
 * Classname WechatAppScreenshot
 * Description TODO
 * Date 2019-06-25 17:18
 * Created by Wang jun gang
 */
@Entity
@Table(name = "wechat_app_screenshot")
@AllOpenAndNoArg
data class WechatAppScreenshot(
        @Id
        @Column(name = "id", nullable = false, length = 36)
        var id: String? = null,
        @Basic
        @Column(name = "created_at", nullable = false)
        var createdAt: Timestamp? = null,
        @Basic
        @Column(name = "image_url", nullable = true, length = 500)
        var imageUrl: String? = null,
        @Basic
        @Column(name = "wechat_app_id", nullable = false, length = 36)
        var wechatAppId: String? = null
)
