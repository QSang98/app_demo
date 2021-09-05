package com.example.demoapp.model

data class UpdateModel(
    val code: Int,
    val data2: Data2,
    val message: String
)

data class Data2(
    val is_app: Int,
    val image_id: String
)