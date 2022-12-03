package com.example.tasbihcounter.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TasbihTable")
data class ItemModel(
    @ColumnInfo(name = "tasbihTitle") var tasbihTitle: String,
    @ColumnInfo(name = "tasbihCount") var tasbihCount: Int,
    @ColumnInfo(name = "isState") var isState: Boolean,
    @ColumnInfo(name = "isSelectState") var isSelectState: Boolean,
    @ColumnInfo(name = "dateTime") var dateTime: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}