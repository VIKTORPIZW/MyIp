package com.example.ip

import android.app.Application
import android.widget.Button
import com.example.ip.data.remote.ip.IpApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class IpApp: Application() {


    lateinit var ipApi:IpApi
    override fun onCreate() {
        super.onCreate()

        configureRetrofit()
    }
    private fun configureRetrofit(){
        val httpLoggerInterceptor = HttpLoggingInterceptor()
        httpLoggerInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggerInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://awstest-balancer-1233234915.us-east-2.elb.amazonaws.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        ipApi = retrofit.create(IpApi::class.java)
    }
}