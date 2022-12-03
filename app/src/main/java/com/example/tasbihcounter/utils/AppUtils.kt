package com.example.tasbihcounter.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object AppUtils {
    @SuppressLint("SimpleDateFormat")
    fun getCurrentDateTime():String{
        val sdf = SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a")
        return sdf.format(Date())
    }
}