package com.example.tasbihcounter.ui.activity

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tasbihcounter.*
import com.example.tasbihcounter.data.adapter.RvAdapter
import com.example.tasbihcounter.data.interfaces.ItemClickListener
import com.example.tasbihcounter.data.model.ItemModel
import com.example.tasbihcounter.databinding.ActivityMainBinding
import com.example.tasbihcounter.utils.AppUtils
import com.example.tasbihcounter.viewmodel.AppViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), ItemClickListener {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: AppViewModel
    lateinit var rvAdapter: RvAdapter
    private var isAllSelectedState = false
    private var items: ItemModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize()
    }

    private fun initialize() {
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]

        binding.addExtFloatingActionButton.setOnClickListener {
            addEditTasbih("Add", items)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        rvAdapter = RvAdapter(this@MainActivity, this) { show, counter -> showDeleteMenu(show, counter) }
        binding.recyclerView.adapter = rvAdapter

        binding.imgvClose.setOnClickListener {
            showDeleteMenu(false, 0)
            rvAdapter.unSelectedAll()
        }
        binding.imgvDelete.setOnClickListener {
            rvAdapter.selectedItems()
            showDeleteMenu(false, 0)
        }

        binding.imgvAllSelect.setOnClickListener {
            isAllSelectedState = !isAllSelectedState
            if (isAllSelectedState){
                binding.imgvAllSelect.setImageResource(R.drawable.ic_select_all)
                rvAdapter.selectedAll()
            } else{
                binding.imgvAllSelect.setImageResource(R.drawable.ic_deselect_all)
                rvAdapter.unSelectedAll()
                showDeleteMenu(true, 0)
            }
        }

        loadData()
    }

    private fun loadData() {
        viewModel.getAllItemList().observe(this) {
            if (it.isEmpty()) {
                binding.apply {
                    emptyTv.isVisible = true
                    recyclerView.isVisible = false
                }
            } else {
                binding.apply {
                    emptyTv.isVisible = false
                    recyclerView.isVisible = true
                }
                rvAdapter.update(it as ArrayList<ItemModel>)
            }
        }
    }

    private fun addEditTasbih(tag: String, items: ItemModel?) {
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(R.layout.add_edit_dialog)
        //bottomSheetDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        val title = bottomSheetDialog.findViewById<TextInputEditText>(R.id.tie_title)
        val hintText = bottomSheetDialog.findViewById<TextInputLayout>(R.id.til_title)
        val saveBtn = bottomSheetDialog.findViewById<Button>(R.id.btn_save)
        val cancelBtn = bottomSheetDialog.findViewById<Button>(R.id.btn_cancel)

        cancelBtn?.setOnClickListener { bottomSheetDialog.dismiss() }

        if (tag.contains("Add")){
            saveBtn?.setOnClickListener {
                viewModel.saveItem(
                    ItemModel(
                        title?.text.toString(),
                        0,
                        true,
                        false,
                        AppUtils.getCurrentDateTime()
                    )
                )
                bottomSheetDialog.dismiss()
            }
        }else if (tag.contains("Update")){
            saveBtn?.text = tag
            title?.setText(items?.tasbihTitle)
            hintText?.hint = "Update Tasbih Name"
            saveBtn?.setOnClickListener {
                items?.tasbihTitle = title?.text.toString()
                viewModel.updateItem(items!!)
                bottomSheetDialog.dismiss()
            }
        }

        bottomSheetDialog.show()
    }

    private fun showDeleteMenu(boolean: Boolean, counter: Int) {
        if (boolean) {
            binding.apply {
                tvTitle.isVisible = false
                imgvClose.isVisible = true
                imgvAllSelect.isVisible = true
                tvCounter.isVisible = true
                tvCounter.text = if (counter == 0) "" else counter.toString()
                imgvDelete.isVisible = true
            }
        } else {
            binding.apply {
                tvTitle.isVisible = true
                imgvClose.isVisible = false
                imgvAllSelect.isVisible = false
                tvCounter.isVisible = false
                tvCounter.text = ""
                imgvDelete.isVisible = false
            }
        }
    }

    override fun onItemClick(itemModel: ItemModel) {
        addEditTasbih("Update", itemModel)
    }
}
