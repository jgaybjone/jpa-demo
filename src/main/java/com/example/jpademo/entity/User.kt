package com.example.jpademo.entity

import com.example.jpademo.annotation.AllOpenAndNoArg
import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.GenericGenerator
import java.sql.Timestamp
import javax.persistence.*

/**
 * Classname User
 * Description
 * Date 2019-06-25 17:18
 * Created by Wang jun gang
 */
@Entity
@Table(name = "user")
@AllOpenAndNoArg
data class User(
        @Id
        @Column(name = "id", nullable = false, length = 20)
        @GeneratedValue(strategy = GenerationType.AUTO, generator = "snow-id-generator")
        @GenericGenerator(name = "snow-id-generator", strategy = "com.example.jpademo.utils.SnowIdGenerator")
        var id: Long? = null,

        @Basic
        @Column(name = "group_id", nullable = true, length = 36)
        var groupId: String? = null,

        @Basic
        @Column(name = "mobile", nullable = true, length = 11)
        var mobile: String? = null,

        @Basic
        @Column(name = "open_id", nullable = true, length = 45)
        var openId: String? = null,

        @Basic
        @Column(name = "username", nullable = true, length = 45)
        var username: String? = null,

        @Basic
        @Column(name = "nickname", nullable = true, length = 45)
        var nickname: String? = null,

        @Basic
        @Column(name = "type", nullable = true)
        var type: Byte? = null,

        @Basic
        @Column(name = "password", nullable = true, length = 512)
        @JsonIgnore
        var password: String? = null,

        @Basic
        @Column(name = "gender", nullable = true)
        var gender: Byte? = null,

        @Basic
        @Column(name = "city", nullable = true, length = 45)
        var city: String? = null,

        @Basic
        @Column(name = "province", nullable = true, length = 45)
        var province: String? = null,

        @Basic
        @Column(name = "country", nullable = true, length = 45)
        var country: String? = null,

        @Basic
        @Column(name = "avatar_url", nullable = true, length = 512)
        var avatarUrl: String? = null,

        @Basic
        @Column(name = "status", nullable = true)
        var status: Byte? = null,

        @Basic
        @Column(name = "union_id", nullable = true, length = 36)
        var unionId: String? = null,

        @Basic
        @Column(name = "authorities", nullable = true, length = 50)
        var authorities: String? = null,

        @Basic
        @Column(name = "source", nullable = true, length = 50)
        var source: String? = null,


        @Basic
        @Column(name = "created_at", nullable = false)
        var createdAt: Timestamp? = null,


        @Basic
        @Column(name = "updated_at", nullable = true)
        var updatedAt: Timestamp? = null

)