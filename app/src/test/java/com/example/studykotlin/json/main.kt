package com.example.studykotlin.json

import java.math.BigDecimal

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/25 下午7:44
 */
fun main() {

    val product = Product("001")

    with(product) {
        name = "高数"
        price = BigDecimal("58")
        features.add(Feature("category", "edu"))
        features.add(Feature("applicable", "大学生"))

    }

    val serializer = JsonSerializer()
    val json = serializer.serialize(product)

    println(json)

}