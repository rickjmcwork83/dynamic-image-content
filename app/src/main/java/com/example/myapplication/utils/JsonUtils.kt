package com.example.myapplication.utils

import android.content.Context
import com.example.myapplication.data.DynamicContent
import com.google.gson.Gson
import java.io.BufferedReader

object JsonUtils {
    fun loadJsonFromAssets(context: Context, fileName: String): String {
        return context.assets.open(fileName).bufferedReader().use(BufferedReader::readText)
    }

    fun parseJson(json: String): DynamicContent {
        return Gson().fromJson(json, DynamicContent::class.java)
    }
}
