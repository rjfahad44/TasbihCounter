package com.example.tasbihcounter

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(itemModel: ItemModel)

    @Update
    suspend fun update(itemModel: ItemModel)

    @Delete
    suspend fun delete(itemModel: ItemModel)

    @Query("DELETE FROM TasbihTable")
    fun deleteAll()

    @Query("SELECT * FROM TasbihTable")
    fun getAll(): LiveData<List<ItemModel>>

    @Query("SELECT * FROM TasbihTable WHERE id Like :itemId")
    fun searchDataById(itemId: Int): LiveData<ItemModel>
}