package com.example.tasbihcounter

import android.view.View

interface ItemClickListener {
    fun itemLongClick(itemModel: ItemModel, view: View)
}