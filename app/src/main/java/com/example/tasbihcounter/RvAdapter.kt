package com.example.tasbihcounter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RvAdapter(private val context: Context,
                private val itemClickListener: ItemClickListener
) : RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    private val itemList = ArrayList<ItemModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_item_view, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tasbihTitleTv.text = itemList[position].tasbihTitle
        holder.tasbihCounterTv.text = itemList[position].tasbihCount.toString()
        holder.dateTimeTv.text = itemList[position].dateTime
        holder.rootCv.setOnClickListener {

        }
        holder.rootCv.setOnClickListener {
            val intent = Intent(context, CounterActivity::class.java)
            intent.putExtra("id", itemList[position].id)
            context.startActivity(intent)
        }

        holder.rootCv.setOnLongClickListener {
            itemClickListener.itemLongClick(itemList[position], holder.dateTimeTv)
            true
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(updateList : ArrayList<ItemModel>){
        itemList.clear()
        itemList.addAll(updateList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = itemList.size

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val rootCv = itemView.findViewById<CardView>(R.id.rootCv)
        val tasbihTitleTv = itemView.findViewById<TextView>(R.id.tasbihTitleTv)
        val tasbihCounterTv = itemView.findViewById<TextView>(R.id.tasbihCounterTv)
        val dateTimeTv = itemView.findViewById<TextView>(R.id.dateTimeTv)
    }
}