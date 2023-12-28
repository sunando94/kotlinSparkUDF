package com.doordash.taskservice.common.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.apache.spark.sql.api.java.UDF1
import org.apache.spark.sql.expressions.UserDefinedFunction

class TranslatorUdf9 : UDF1<Long, String> {
    override fun call(taskGroupDataBytes: Long): String {
    val deserializedPerson ="hello"
    return deserializedPerson
    }
}
