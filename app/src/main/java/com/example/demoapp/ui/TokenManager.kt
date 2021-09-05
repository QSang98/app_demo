package com.example.demoapp.ui

import android.content.Context
import android.content.SharedPreferences
import com.example.demoapp.R

class TokenManager(context: Context) {

    private var pref: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    fun saveToken(token: String?) {
        val editor = pref.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    fun fetchToken(): String? {
        return pref.getString(USER_TOKEN, null)
    }

    companion object {
        const val USER_TOKEN = "user_token"
    }
}