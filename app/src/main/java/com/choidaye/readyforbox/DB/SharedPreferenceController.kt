package com.choidaye.readyforbox.DB

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceController{

    val MY_ACCOUNT = "unique_string"

    fun setUserToken(ctx: Context, authorization : String){
        val preference: SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preference.edit()
        editor.putString("u_token",authorization)
        editor.commit()
    }

    fun getUserToken(ctx: Context): String{
        val preference: SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        return preference.getString("u_token", "")
    }

    fun clearUserToken(ctx: Context){
        val preference: SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preference.edit()
        editor.clear()
        editor.commit()
    }
}