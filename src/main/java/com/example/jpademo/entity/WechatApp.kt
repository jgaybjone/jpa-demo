package com.example.jpademo.entity

import com.example.jpademo.annotation.AllOpenAndNoArg
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.sql.Timestamp
import javax.persistence.*

/**
 * Classname WechatApp
 * Description
 * Date 2019-06-25 17:18
 * Created by Wang jun gang
 */
@Entity
@Table(name = "wechat_app")
@JsonIgnoreProperties(value = ["handler", "fieldHandler"])
@AllOpenAndNoArg
data class WechatApp(
        @Id
        @Column(name = "id", nullable = false, length = 36)
        var id: String? = null,

        @Basic
        @Column(name = "author", nullable = true, length = 100)
        var author: String? = null,

        @Basic
        @Column(name = "name", nullable = false, length = 36)
        var name: String? = null,

        @Basic
        @Column(name = "description", nullable = true, length = 2000)
        var description: String? = null,

        @Basic
        @Column(name = "created_at", nullable = true)
        var createdAt: Timestamp? = null,

        @Basic
        @Column(name = "icon", nullable = true, length = 255)
        var icon: String? = null,

        @Basic
        @Column(name = "status", nullable = true)
        var status: Byte? = null,

        @Basic
        @Column(name = "group_id", nullable = true, length = 36)
        var groupId: String? = null,

        @Basic
        @Column(name = "url", nullable = true, length = 500)
        var url: String? = null,

        @OneToMany(targetEntity = WechatAppQrcode::class, cascade = [CascadeType.PERSIST, CascadeType.REMOVE])
        @JoinColumn(name = "wechat_app_id")
        var qrcodes: List<WechatAppQrcode>? = emptyList()

)
