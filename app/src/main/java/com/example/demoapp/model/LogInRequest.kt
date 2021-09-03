package com.example.demoapp.model

data class LogInRequest(
    val email: String,
    val pwd: String,
    val application: String,
    val application_type: Int,
    val application_version: String,
    val device_id: String,
    val device_name: String,
    val device_type: Int,
    val os_version: String,
    val api: String
)