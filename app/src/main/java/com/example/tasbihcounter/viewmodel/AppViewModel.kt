package com.example.tasbihcounter.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tasbihcounter.data.model.ItemModel
import com.example.tasbihcounter.repository.AppRepository

class AppViewModel(application: Application): AndroidViewModel(application) {

    var model = MutableLiveData<ItemModel>()

    private val repository: AppRepository = AppRepository(application)
    private val allItems: LiveData<MutableList<ItemModel>> = repository.getAllList()

    fun saveItem(itemModel: ItemModel) {
        repository.saveItem(itemModel)
    }

    fun saveItems(todoItems: MutableList<ItemModel>) {
        repository.saveItems(todoItems)
    }

    fun updateItem(itemModel: ItemModel) {
        repository.updateItem(itemModel)
    }

    fun deleteItem(itemModel: ItemModel) {
        repository.deleteItem(itemModel)
    }

    fun deleteItems(items: MutableList<ItemModel>) {
        repository.deleteItem(items)
    }

    fun clearItems() {
        repository.clearItems()
    }

    fun searchItemById(id: Int): LiveData<ItemModel> = repository.searchItemById(id)

//    fun itemCheckState(itemModel: ItemModel) {
//        itemModel.isCheck = !itemModel.isCheck
//        repository.updateTodoItem(itemModel)
//    }

    fun getAllItemList(): LiveData<MutableList<ItemModel>> {
        return allItems
    }
}