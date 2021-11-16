package com.example.ip.data.remote.ip

import io.reactivex.Single
import retrofit2.http.GET

interface IpApi {
    @GET("./awstest-service/")
    fun getIP():Single<IpResponse>
}