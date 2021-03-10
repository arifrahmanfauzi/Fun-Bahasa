package com.android.funbahasa.data.service

import com.android.funbahasa.data.model.Response
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface Service {

    @GET("posts?filter[puisi]")
    fun getPuisi() : Flowable<ArrayList<Response>>
}