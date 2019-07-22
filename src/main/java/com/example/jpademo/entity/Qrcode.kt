package com.example.jpademo.entity

import com.example.jpademo.annotation.AllOpenAndNoArg
import java.sql.Timestamp
import javax.persistence.*

/**
 * Classname Qrcode
 * Description
 * Date 2019-06-25 17:18
 * Created by Wang jun gang
 */
@Entity
@Table(name = "qrcode")
@AllOpenAndNoArg
data class Qrcode(
        @Id
        @Column(name = "id", nullable = false, length = 36)
        var id: String? = null,
        @Basic
        @Column(name = "image_url", nullable = false, length = 500)
        var imageUrl: String? = null,
        @Basic
        @Column(name = "created_at", nullable = false)
        var createdAt: Timestamp? = null,
        @Basic
        @Column(name = "deleted", nullable = true)
        var deleted: Boolean? = null
)
