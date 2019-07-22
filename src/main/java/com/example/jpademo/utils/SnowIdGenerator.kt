package com.example.jpademo.utils

import org.apache.commons.lang.reflect.FieldUtils
import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.id.IdentityGenerator
import java.io.Serializable

/**
 * Classname SnowIdGenerator
 * Description
 * Date 2019-07-01 10:26
 * Created by Wang jun gang
 */
class SnowIdGenerator : IdentityGenerator() {

    private val snowflakesTools: SnowflakesTools = SnowflakesTools.getInstanceSnowflake()

    override fun generate(s: SharedSessionContractImplementor?, obj: Any?): Serializable {

        val id = FieldUtils.readField(obj, "id", true)

        if (id != null) {
            return id as Serializable
        }

        return snowflakesTools.nextId()
    }
}