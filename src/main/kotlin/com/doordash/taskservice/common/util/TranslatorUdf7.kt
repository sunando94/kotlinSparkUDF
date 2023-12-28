package com.doordash.taskservice.common.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.apache.spark.sql.api.java.UDF1

data class Person(val name: String, val age: Int){
    override fun toString(): String = "Name:"+ name + "Age:" + age
}

class TranslatorUdf7 : UDF1<Long, String> {
    override fun call(taskGroupDataBytes: Long): String {
    val objectMapper: ObjectMapper = jacksonObjectMapper().findAndRegisterModules()
    val person = Person("John Doe", 30)

    // Serialization to JSON
    val json: String = objectMapper.writeValueAsString(person)
    println("JSON: $json")

    // Deserialization from JSON
    val deserializedPerson: Person = objectMapper.readValue(json, Person::class.java)
    println("Deserialized Person: $deserializedPerson")


    return deserializedPerson.toString()
    }

}
