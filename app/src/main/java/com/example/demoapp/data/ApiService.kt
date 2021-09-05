package com.example.demoapp.data

import com.example.demoapp.model.*
import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.http.*

interface ApiService {

    @POST("/")
    fun userLogIn(@Body logInRequest: LogInRequest): Single<LogInModel>

    @POST("/")
    fun getUser(@Body userRequest: UserRequest): Single<UserModel>

    @POST("/api={api}&token={token}&img_cat=3&file_id=&sum={sum}&size={size}&time={time}")
    fun updateUser(
        @Path("api") api: String,
        @Path("token") token: String,
        @Path("sum") sum: String,
        @Path("size") size: Long,
        @Path("time") time: Long,
        @Body requestBody: RequestBody,
    ): Single<UpdateModel>
}
