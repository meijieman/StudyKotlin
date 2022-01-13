package com.major.booklib.api

import com.major.booklib.bean.Book
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * TODO
 *
 * @author meijie05
 * @since 2020/7/4 上午7:17
 */
interface BookApiService {

    @GET("books")
    fun list(): Observable<BaseResponse<List<Book>>>

    companion object {
        fun <T> create(clazz: Class<T>): T {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://10.0.2.2:8080/api/")
                .build()

            return retrofit.create(clazz)
        }
    }
}