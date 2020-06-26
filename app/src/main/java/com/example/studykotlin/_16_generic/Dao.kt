package com.example.studykotlin._16_generic

interface Dao<T> {
    fun save(t: T): Long

    fun get(id: Long): T?
}