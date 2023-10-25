package com.example.trysharepref.utils

import android.content.Context
import android.content.SharedPreferences

class CustomSharePrefs(val context:Context) {

    private val prefs:SharedPreferences = context.getSharedPreferences("SIMPAN_TOKEN",Context.MODE_PRIVATE)

    fun saveLogin(login:Int) {
        val editor = prefs.edit()
        editor.putInt("SAVE_LOGIN",login)
        editor.apply()
    }

    fun getLogin():Int = prefs.getInt("SAVE_LOGIN",0)
}