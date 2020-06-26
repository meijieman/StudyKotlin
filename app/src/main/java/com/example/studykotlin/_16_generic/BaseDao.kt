package com.example.studykotlin._16_generic

import java.util.*

abstract class BaseDao<T : Entity> : Dao<T> {
    // 表示数据库
    var table = mutableMapOf<Long, T>()

    override fun save(t: T): Long {

        t.id = System.currentTimeMillis()
        t.createdAt = Date()
        t.updatedAt = t.createdAt
        table[t.id] = t

        return t.id
    }

    override fun get(id: Long): T? {
        return table[id]
    }
}