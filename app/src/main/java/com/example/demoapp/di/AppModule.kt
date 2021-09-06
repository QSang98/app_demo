package com.example.demoapp.di

import android.content.Context
import com.example.demoapp.BuildConfig
import com.example.demoapp.data.ApiService
import com.example.demoapp.data.ApiService1
import com.example.demoapp.data.AuthenInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesApiservice(@Named("Login") retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    fun providesApiservice1(@Named("Update") retrofit: Retrofit): ApiService1 = retrofit.create(ApiService1::class.java)

    @Provides
    @Named("Login")
    fun providesRetrofit(gson: Gson, httpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(httpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    @Named("Update")
    fun providesRetrofit1(gson: Gson, httpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL_UPDATE)
        .client(httpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun providesClientBuilder(authenInterceptor: AuthenInterceptor, httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()

        return clientBuilder.addInterceptor(httpLoggingInterceptor).addInterceptor(authenInterceptor).build()
    }

    @Provides
    fun providesInterceptor(@ApplicationContext context: Context): AuthenInterceptor {
        return AuthenInterceptor(context)
    }

    @Provides
    fun providesGson(): Gson {
        return GsonBuilder().setLenient().create()
    }

    @Provides
    fun providesOkHttp(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
        else HttpLoggingInterceptor.Level.NONE
        return loggingInterceptor
    }
}
