package com.example.tasbihcounter.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tasbihcounter.data.model.ItemModel

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveItem(itemModel: ItemModel)

    @Insert
    suspend fun saveItems(todoModel: MutableList<ItemModel>)

    @Update
    suspend fun update(itemModel: ItemModel)

    @Delete
    suspend fun delete(itemModel: ItemModel)

    @Delete
    suspend fun deleteList(items: MutableList<ItemModel>)

    @Query("DELETE FROM TasbihTable")
    fun deleteAll()

    @Query("SELECT * FROM TasbihTable ORDER BY id DESC")
    fun getAll(): LiveData<MutableList<ItemModel>>

    @Query("SELECT * FROM TasbihTable WHERE id Like :itemId")
    fun searchDataById(itemId: Int): LiveData<ItemModel>

    @Query("SELECT * FROM TasbihTable")
    fun all(): MutableList<ItemModel>
}