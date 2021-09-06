package com.example.demoapp.model

import com.google.gson.annotations.SerializedName

data class UpdateModel(
    val code: Int,
    @SerializedName("data")
    val data2: Data2,
    val message: String
)

data class Data2(
    val is_app: Int,
    val image_id: String
)