package com.example.tasbihcounter

import android.app.Application
import android.util.Log
import com.example.tasbihcounter.data.DefaultTasbihAdded
import com.example.tasbihcounter.data.database.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TasbihApplication : Application() {
    companion object {
        lateinit var context: Application
        private val scope = CoroutineScope(Dispatchers.IO)
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext as Application
        scope.launch {
            try {
                val database = AppDatabase.getDatabase()?.itemDao()
                if (database?.all()?.isEmpty()!!) {
                    DefaultTasbihAdded().insertDefaultTasbih(database)
                }
            } catch (e: Exception) {
                Log.d("TAG","run.. ${e.message}")
            }
        }
    }
}