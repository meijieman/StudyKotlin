package com.major.booklib.api

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/7/4 上午7:14
 */
data class BaseResponse<T>(val data:T, val code:Int = 0)