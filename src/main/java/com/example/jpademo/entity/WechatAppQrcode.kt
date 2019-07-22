package com.example.jpademo.entity

import com.example.jpademo.annotation.AllOpenAndNoArg
import lombok.Data
import javax.persistence.*

/**
 * Classname WechatAppQrcode
 * Description
 * Date 2019-06-25 17:18
 * Created by Wang jun gang
 */
@Entity
@Table(name = "wechat_app_qrcode")
@Data
@AllOpenAndNoArg
data class WechatAppQrcode(
        //    @ManyToOne(targetEntity = WechatApp.class)
        //    @JoinColumn(name = "wechat_app_id")
        //    private WechatApp wechatApp;


        @Id
        @Column(name = "id", nullable = false, length = 36)
        var id: String? = null,
        @Basic
        @Column(name = "wechat_app_id", nullable = true, length = 36)
        var wechatAppId: String? = null,
        @Basic
        @Column(name = "qrcode_id", nullable = true, length = 36)
        var qrcodeId: String? = null
)
