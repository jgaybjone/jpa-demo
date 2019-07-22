package com.example.jpademo.interfaces.controller

import com.example.jpademo.annotation.AllOpenAndNoArg
import com.example.jpademo.entity.User
import com.example.jpademo.entity.WechatApp
import com.example.jpademo.repository.UserRepository
import com.example.jpademo.service.WechatAppService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.sql.Timestamp
import java.time.Duration
import java.time.LocalDateTime

/**
 * Classname TestController
 * Description
 * Date 2019-06-25 17:28
 * Created by Wang jun gang
 */
@RestController
@RequestMapping("/test")
class TestController {

    val log = LoggerFactory.getLogger(this.javaClass)!!

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var wechatAppService: WechatAppService

    @GetMapping("/users")
    fun users(): Mono<List<User>> {

        return Mono.create { sink ->
            sink.success(userRepository.findAllById(listOf("298348970482860032")))
        }

    }

    @PostMapping("/user")
    fun addUser(@RequestBody userInfo: UserInfo): Mono<String?> {

        return Mono.create {
            val user = User()
            user.username = userInfo.username
            user.password = userInfo.password
            user.createdAt = Timestamp.valueOf(LocalDateTime.now())
            userRepository.save(user)

            it.success("ok")
        }
    }


    @GetMapping("/wechatapps")
    fun wechatApps(): Flux<WechatApp> {

        return Flux.fromIterable(wechatAppService.crudAndFunction {
            it.findAll(PageRequest.of(1, 10))
        })

    }

    @GetMapping("/wechatapp/{id}")
    fun wechatApp(@PathVariable id: String): Mono<WechatApp> {
        return Mono.create {
            it.success(wechatAppService.findByIdEager(id).get())
        }
    }

    @GetMapping("/wechatapp_lazy/{id}")
    fun wechatAppLazy(@PathVariable id: String): Mono<WechatApp> {

        wechatAppService.crudAndConsumer { repository ->
            val optional = repository.findById(id)
            log.info(optional.get().toString())
        }

        return Mono.create {
            it.success(wechatAppService.findByIdLazy(id).get())
        }
    }

    @GetMapping(value = ["/seri"])
    fun serializer(): Mono<User> {
        return Mono.create {
            val user = User()
            user.username = "apollo"
            user.mobile = "13389898989"
            user.city = "Shanghai"
            it.success(user)
        }
    }

    @GetMapping(value = ["/interval"], produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun interval(): Flux<Map<String, String>> {
        return Flux.interval(Duration.ofSeconds(1)).map {
            mapOf(pair = Pair("number", "$it"))
        }
    }
}

@AllOpenAndNoArg
data class UserInfo(var username: String?, var password: String?)
