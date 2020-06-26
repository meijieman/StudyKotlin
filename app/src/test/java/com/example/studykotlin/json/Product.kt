package com.example.studykotlin.json

import java.math.BigDecimal

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/25 下午7:41
 */
class Product(@JsonField("product_code") val productCode: String) {

    @JsonExclude
    var id: Int = 0

    @JsonField("product_name")
    var name: String? = null
    var price: BigDecimal = BigDecimal.ZERO
    var features: MutableList<Feature> = mutableListOf()


}