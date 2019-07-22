package com.example.jpademo.entity

import com.example.jpademo.annotation.AllOpenAndNoArg
import java.sql.Timestamp
import javax.persistence.*

/**
 * Classname Tag
 * Description
 * Date 2019-06-25 17:18
 * Created by Wang jun gang
 */
@Entity
@Table(name = "tag")
@AllOpenAndNoArg
data class Tag(
        @Id
        @Column(name = "id", nullable = false)
        var id: Int = 0,

        @Basic
        @Column(name = "name", nullable = false, length = 100)
        var name: String? = null,

        @Basic
        @Column(name = "icon", nullable = true, length = 500)
        var icon: String? = null,

        @Basic
        @Column(name = "priority", nullable = true)
        var priority: Int? = null,

        @Basic
        @Column(name = "created_at", nullable = false)
        var createdAt: Timestamp? = null
)
