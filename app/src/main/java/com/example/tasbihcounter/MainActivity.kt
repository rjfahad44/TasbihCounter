package com.example.tasbihcounter

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tasbihcounter.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), ItemClickListener {

    lateinit var binding: ActivityMainBinding
    lateinit var rvAdapter: RvAdapter
    lateinit var itemDao: ItemDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialize()
    }

    private fun initialize() {
        itemDao = AppDatabase.getDatabase(this)!!.itemDao()

        binding.addFloatingActionButton.setOnClickListener {
            addTasbih()
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        rvAdapter = RvAdapter(this, this)
        binding.recyclerView.adapter = rvAdapter

        loadData()
    }

    private fun loadData() {
        lifecycleScope.launch {
            itemDao.getAll().observe(this@MainActivity){
                if (it.isEmpty()){
                    binding.emptyTv.isVisible = true
                    binding.recyclerView.isVisible = false
                }else{
                    binding.emptyTv.isVisible = false
                    binding.recyclerView.isVisible = true
                    rvAdapter.update(it as ArrayList<ItemModel>)
                }
            }
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun addTasbih() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.entry_dialog)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        val nameEt = dialog.findViewById<EditText>(R.id.nameEt)
        dialog.findViewById<TextView>(R.id.cancelTv).setOnClickListener { dialog.dismiss() }
        dialog.findViewById<TextView>(R.id.saveTv).setOnClickListener {
            lifecycleScope.launch {
                val today = Date()
                val format = SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a")
                val dateTimeToStr = format.format(today)
                if (nameEt.text.toString().isEmpty()){
                    Toast.makeText(this@MainActivity, "Name is empty!!", Toast.LENGTH_SHORT).show()
                }else{
                    itemDao.insert(ItemModel(nameEt.text.toString(), 0, true, dateTimeToStr))
                    dialog.dismiss()
                }
            }
        }
        dialog.show()
    }

    @SuppressLint("NewApi")
    override fun itemLongClick(itemModel: ItemModel, view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)
        popupMenu.setForceShowIcon(true)
        popupMenu.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.deleteAllMenu->{
                    lifecycleScope.launch {
                        itemDao.deleteAll()
                        Toast.makeText(this@MainActivity, "Clear All Items", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.deleteSingleMenu->{
                    lifecycleScope.launch {
                        itemDao.delete(itemModel)
                        Toast.makeText(this@MainActivity, "Delete.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            true
        }
        popupMenu.show()
    }
}
