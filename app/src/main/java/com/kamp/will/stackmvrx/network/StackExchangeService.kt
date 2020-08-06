package com.kamp.will.stackmvrx.network

import com.kamp.will.stackmvrx.model.Questions
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Retrofit service interface to the stack exchange API
 *
 * {@see [API](https://api.stackexchange.com/docs)
 */
interface IStackExchangeService {

    /**
     * Gets all the questions on the site.
     *
     * {@see [API](https://api.stackexchange.com/docs/questions) }
     */
    @Headers("Accept: application/json", "Content-Type: application/json")
    @GET("/2.2/questions")
    fun questionsInternal(
        @Query("order") order: String,
        @Query("sort") sort: String,
        @Query("format") format: String = "json",
        @Query("site") site: String = "stackoverflow"
    ): Questions
}

class StackExchangeService {
    private val service = retrofit.create(IStackExchangeService::class.java)

    @JvmOverloads
    fun questions(order: String = "desc", sort: String = "activity"): Questions =
        service.questionsInternal(order = order, sort = sort)
}

private val retrofit by lazy {
    Retrofit.Builder()
        .baseUrl("https://api.stackexchange.com")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
}

private val moshi by lazy {
    Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}