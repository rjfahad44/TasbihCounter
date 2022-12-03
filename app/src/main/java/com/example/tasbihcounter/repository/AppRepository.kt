package com.example.tasbihcounter.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.tasbihcounter.data.dao.ItemDao
import com.example.tasbihcounter.data.database.AppDatabase
import com.example.tasbihcounter.data.model.ItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class AppRepository(application: Application) {
    private val itemDao: ItemDao
    private val allItems: LiveData<MutableList<ItemModel>>

    init {
        val database = AppDatabase.getDatabase()
        itemDao = database!!.itemDao()
        allItems = itemDao.getAll()
    }

    fun saveItems(itemModel: MutableList<ItemModel>) = runBlocking(Dispatchers.IO) {
        itemDao.saveItems(itemModel)
    }

    fun saveItem(itemModel: ItemModel) = runBlocking(Dispatchers.IO) {
        itemDao.saveItem(itemModel)
    }

    fun updateItem(itemModel: ItemModel) = runBlocking(Dispatchers.IO) {
        itemDao.update(itemModel)
    }

    fun deleteItem(itemModel: ItemModel) = runBlocking(Dispatchers.IO) {
        itemDao.delete(itemModel)
    }

    fun deleteItem(items: MutableList<ItemModel>) = runBlocking(Dispatchers.IO) {
        itemDao.deleteList(items)
    }

    fun clearItems() = runBlocking(Dispatchers.IO) {
        itemDao.deleteAll()
    }

    fun searchItemById(id: Int) = runBlocking(Dispatchers.IO) {
        itemDao.searchDataById(id)
    }

    fun getAllList(): LiveData<MutableList<ItemModel>> {
        return allItems
    }
}