package com.example.studykotlin._16_generic

import java.math.BigDecimal

fun main() {

    val productDao = ProductDao()
    val product = Product().apply {
        code = "B001"
        name = "Kotlin"
        price = BigDecimal(20)
    }
    val pid = productDao.save(product)
    val get = productDao.get(pid)
    println("pid $pid, get $get")

    val stockDao = StockDao()
    val stock = Stock().apply {
        name = "一号仓库"
        products = listOf(product)
    }
    val sid = stockDao.save(stock)
    val get1 = stockDao.get(sid)
    println("sid $sid, get1 $get1")


}