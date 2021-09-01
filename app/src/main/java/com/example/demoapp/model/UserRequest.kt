package com.example.demoapp.model

data class UserRequest(
    var email: String,
    var pwd: String,
    var application: String,
    var application_type: Int,
    var application_version: String,
    var device_id: String,
    var device_name: String,
    var device_type: Int,
    var os_version: String,
    var api: String
)