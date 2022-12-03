package com.example.tasbihcounter.data.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.tasbihcounter.R
import com.example.tasbihcounter.data.interfaces.ItemClickListener
import com.example.tasbihcounter.data.model.ItemModel
import com.example.tasbihcounter.databinding.RvItemViewBinding
import com.example.tasbihcounter.ui.activity.CounterActivity
import com.example.tasbihcounter.ui.activity.MainActivity
import com.example.tasbihcounter.viewmodel.AppViewModel

class RvAdapter(
    private val context: Context,
    private val itemClickListener: ItemClickListener,
    private val showDeleteMenu: (Boolean, Int) -> Unit
) : RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    lateinit var viewModel: AppViewModel
    private var itemList = ArrayList<ItemModel>()
    private var isSelected = false
    private var isSelectedAll = false
    private var selectedItems = mutableListOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RvItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        viewModel = ViewModelProvider(context as MainActivity)[AppViewModel::class.java]
        holder.binding.tasbihTitleTv.text = itemList[position].tasbihTitle
        holder.binding.tasbihCounterTv.text = itemList[position].tasbihCount.toString()
        holder.binding.dateTimeTv.text = itemList[position].dateTime

        if (!isSelected){
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO){
                holder.binding.rootCv.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
            }else{
                holder.binding.rootCv.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.black700))
            }
        }

        if (isSelectedAll){
            selectedItems.add(position)
            itemList[position].isSelectState = true
            showDeleteMenu(true, selectedItems.size)
            holder.binding.rootCv.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.green))
        }

        holder.itemView.setOnClickListener {
            if (selectedItems.contains(position)) {
                selectedItems.removeAt(selectedItems.indexOf(position))
                //holder.binding.rootCv.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO){
                    holder.binding.rootCv.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
                }else{
                    holder.binding.rootCv.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.black700))
                }
                itemList[position].isSelectState = false
                showDeleteMenu(true, selectedItems.size)
                if (selectedItems.isEmpty()) {
                    showDeleteMenu(false, 0)
                    isSelected = false
                }
            } else if (isSelected) {
                selectMultipleItem(holder, itemList[position], position)
            } else {
                val intent = Intent(context, CounterActivity::class.java)
                intent.putExtra("id", itemList[position].id)
                intent.putExtra("title", itemList[position].tasbihTitle)
                context.startActivity(intent)
            }
        }

        holder.itemView.setOnLongClickListener {
            selectMultipleItem(holder, itemList[position], position)
            true
        }

        holder.binding.imgvMenu.setOnClickListener {
            itemClickListener.onItemClick(itemList[position])
        }

    }

    private fun selectMultipleItem(holder: RvAdapter.ViewHolder, itemModel: ItemModel, position: Int) {
        isSelected = true
        selectedItems.add(position)
        itemModel.isSelectState = true
        showDeleteMenu(true, selectedItems.size)
        holder.binding.rootCv.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.green))
    }

    override fun getItemCount(): Int = itemList.size

    inner class ViewHolder(val binding: RvItemViewBinding) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifyDataSetChanged")
    fun update(updateList: ArrayList<ItemModel>) {
        itemList = updateList
        notifyDataSetChanged()
    }

    fun unSelectedAll() {
        isSelected = false
        isSelectedAll = false
        selectedItems.clear()
        notifyDataSetChanged()
    }

    fun selectedAll() {
        isSelected = true
        isSelectedAll = true
        selectedItems.clear()
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun selectedItems() {
        if (selectedItems.isNotEmpty()) {
            //itemList.removeAll { items -> items.isSelectState }
            itemList.forEach {
                if (it.isSelectState){
                    viewModel.deleteItem(it)
                }
            }
            isSelected = false
            selectedItems.clear()
        }
    }
}