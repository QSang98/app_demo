package com.example.demoapp.data

import com.example.demoapp.model.UpdateModel
import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService1 {
    @POST("api={api}&token={token}&img_cat=3&file_id=&sum={sum}&size={size}&time={time}")
    fun updateUser(
        @Path("api") api: String,
        @Path("token") token: String,
        @Path("sum") sum: String,
        @Path("size") size: Long,
        @Path("time") time: Long,
        @Body requestBody: RequestBody,
    ): Single<UpdateModel>
}