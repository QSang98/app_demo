package com.example.demoapp.data

import android.content.Context
import com.example.demoapp.ui.MainFragment
import okhttp3.Interceptor
import okhttp3.Response

class AuthenInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        MainFragment.newInstance().token?.let {
            requestBuilder.addHeader("Content-Type", "application/json")
            requestBuilder.addHeader("User-Agent", "android")
            requestBuilder.addHeader("Authorization", "Bearer $it")
        }

        return chain.proceed(requestBuilder.build())
    }
}
