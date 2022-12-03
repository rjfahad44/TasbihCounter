package com.example.tasbihcounter.data.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tasbihcounter.TasbihApplication.Companion.context
import com.example.tasbihcounter.data.dao.ItemDao
import com.example.tasbihcounter.data.model.ItemModel

@Database(entities = [ItemModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(): AppDatabase? {
            if (INSTANCE == null) synchronized(AppDatabase::class.java) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext, AppDatabase::class.java, "USER_DATABASE")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}