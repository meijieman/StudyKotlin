package com.example.studykotlin._16_generic

import java.math.BigDecimal

class Product : Entity() {

    var code: String? = null
    var name: String? = null
    var price: BigDecimal? = null

    override fun toString(): String {
        return "Product(code=$code, name=$name, price=$price)"
    }

}