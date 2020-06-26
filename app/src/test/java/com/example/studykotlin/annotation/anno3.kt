package com.example.studykotlin.annotation

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/6/25 下午5:33
 */

/* 元注解：应用在注解上的注解

Target 元注解，指定注解可以应用的范围

Retention 元注解，指定注解的保存位置

Repeatable 元注解，在一个位置同时添加多个同名的注解

MustBeDocument 元注解，表示其标记的注解应该包含在生成的 api 文档中
 */

@Repeatable
@Retention(AnnotationRetention.SOURCE)
annotation class Alias(val name: String)

class User2 {

    @Alias("name")
    @Alias("first_name")
    @Alias("firstName")
    val name: String = ""
}















