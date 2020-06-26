package com.example.studykotlin.json

import kotlin.reflect.full.memberProperties

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/25 下午7:20
 */
class JsonSerializer {

    fun serialize(any: Any): String = parseObject(any)

    private fun parseObject(any: Any): String {
        val clazz = any::class
        // 获取所有属性
        val json = clazz.memberProperties
            .filter {
                val annotations = it.annotations
                val jsonExclude = annotations.firstOrNull { anno ->
                    anno.annotationClass.qualifiedName == JsonExclude::class.qualifiedName
                }

                // true 表示不需要被过滤
                jsonExclude == null
            }
            .joinToString(",") {
                val propertyValue = it.call(any)

                val annotations = it.annotations
                val jsonField = annotations.firstOrNull { anno ->
                    anno.annotationClass.qualifiedName == JsonField::class.qualifiedName
                }

                val fieldName = if (jsonField == null) {
                    it.name
                } else {
                    (jsonField as JsonField).name
                }

                if (propertyValue is List<*>) {
                    parseList(fieldName, propertyValue)
                } else {
                    parseProperty(fieldName, propertyValue)
                }
            }

        return "{$json}"
    }

    private fun parseList(name: String, array: List<*>): String {
        return buildString {
            append("\"")
            append(name)
            append("\": ")
            append("[")
            val json = array.mapNotNull {
                parseObject(it!!)
            }.joinToString(",")

            append(json)
            append("]")
        }
    }

    private fun parseProperty(name: String, value: Any?): String {
        return """
            |"$name":"$value"
        """.trimMargin()
    }

}
