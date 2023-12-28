package com.doordash.taskservice.common.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.gson.Gson
import org.apache.spark.sql.api.java.UDF1
import org.apache.spark.sql.expressions.UserDefinedFunction

class TranslatorUdf8 : UDF1<Long, String> {
    override fun call(taskGroupDataBytes: Long): String {
    var gson = Gson()
//    val objectMapper: ObjectMapper = jacksonObjectMapper().findAndRegisterModules()
    val person = Person("John Doe", 30)
//
//    // Serialization to JSON
    val json: String = gson.toJson(person)
   println("JSON: $json")
//
//    // Deserialization from JSON
    val deserializedPerson: Person = gson.fromJson(json, Person::class.java)
    println("Deserialized Person: $deserializedPerson")


    return deserializedPerson.toString()
    }
}
