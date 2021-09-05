package com.example.demoapp.data

import android.content.Context
import com.example.demoapp.ui.TokenManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthenInterceptor(context: Context) : Interceptor {

    private val tokenManager = TokenManager(context)

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        tokenManager.fetchToken()?.let {
            requestBuilder.addHeader("Content-Type", "application/json")
            requestBuilder.addHeader("User-Agent", "android")
            requestBuilder.addHeader("Authorization", "Bearer $it")
        }

        return chain.proceed(requestBuilder.build())
    }
}
