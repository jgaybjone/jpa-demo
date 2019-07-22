package com.example.jpademo

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jackson.JacksonProperties
import org.springframework.boot.runApplication
import org.springframework.boot.web.codec.CodecCustomizer
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.codec.json.Jackson2JsonDecoder
import org.springframework.http.codec.json.Jackson2JsonEncoder
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.util.MimeTypeUtils

@SpringBootApplication
@EnableEurekaClient
class JpaDemoApplication

fun main(args: Array<String>) {
    runApplication<JpaDemoApplication>(*args)
}

@Configuration
class XmlMessage {

    fun xmlMapper(jacksonProperties: JacksonProperties): XmlMapper {
        val builder = Jackson2ObjectMapperBuilder.xml()
        if (jacksonProperties.defaultPropertyInclusion != null) {
            builder.serializationInclusion(jacksonProperties.defaultPropertyInclusion)
        }
        if (jacksonProperties.timeZone != null) {
            builder.timeZone(jacksonProperties.timeZone)
        }

        return builder.build()
    }

    @Bean
    fun xmlCodecCustomizer(jacksonProperties: JacksonProperties): CodecCustomizer {
        val xmlMapper = xmlMapper(jacksonProperties)
        return CodecCustomizer {
            val customCodecs = it.customCodecs()
            customCodecs.decoder(Jackson2JsonDecoder(xmlMapper, MimeTypeUtils.APPLICATION_XML))
            customCodecs.encoder(Jackson2JsonEncoder(xmlMapper, MimeTypeUtils.APPLICATION_XML))
        }
    }
}