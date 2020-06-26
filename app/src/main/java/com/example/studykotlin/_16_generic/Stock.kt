package com.example.studykotlin._16_generic

class Stock : Entity() {
    var name: String? = null
    var products: List<Product> = listOf()

    override fun toString(): String {
        return "Stock(name=$name, products=$products)"
    }

}