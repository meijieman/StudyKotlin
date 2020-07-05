package com.major.booklib.bean

import java.math.BigDecimal

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/7/4 上午7:15
 */

data class Book(val id: Long) {

    constructor(id: Long, bookName: String, author: String) : this(id) {
        this.bookName = bookName
        this.author = author
    }

    var bookName: String = ""
    var author: String = ""
    var price: BigDecimal = BigDecimal.ZERO
    var cover: String = ""
    var summary: String = ""

}
