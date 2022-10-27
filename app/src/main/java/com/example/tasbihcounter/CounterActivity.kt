package com.example.tasbihcounter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.tasbihcounter.databinding.ActivityCounterBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class CounterActivity : AppCompatActivity() {

    lateinit var binding: ActivityCounterBinding
    lateinit var itemDao: ItemDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize()
    }

    private fun initialize() {
        itemDao = AppDatabase.getDatabase(this)!!.itemDao()
        val id: Int = intent.extras!!.getInt("id")
        lifecycleScope.launch {
            itemDao.searchDataById(id).observe(this@CounterActivity) { itemModel ->
                binding.apply {
                    title.text = itemModel.tasbihTitle
                    title.setSingleLine()
                    title.ellipsize = TextUtils.TruncateAt.MARQUEE
                    title.marqueeRepeatLimit = -1
                    title.isSelected = true
                    counterTv.text = itemModel.tasbihCount.toString()
                    dateTimeTv.text = itemModel.dateTime
                    switchBtn.isChecked = itemModel.isState
                    if (itemModel.isState) {
                        plusMinusImVBtn.setImageResource(R.drawable.add)
                        switchTextTv.text = "Plus"
                    } else {
                        plusMinusImVBtn.setImageResource(R.drawable.minus)
                        switchTextTv.text = "Minus"
                    }
                    switchBtn.setOnCheckedChangeListener { compoundButton, boolean ->
                        itemModel.isState = !itemModel.isState
                        updateDatabase(itemModel)
                        if (itemModel.isState) {
                            plusMinusImVBtn.setImageResource(R.drawable.add)
                            switchTextTv.text = "Plus"
                        } else {
                            plusMinusImVBtn.setImageResource(R.drawable.minus)
                            switchTextTv.text = "Minus"
                        }
                    }

                    plusMinusImVBtn.setOnClickListener {
                        if (itemModel.isState) {
                            itemModel.tasbihCount = itemModel.tasbihCount.plus(1)
                        } else {
                            itemModel.tasbihCount = itemModel.tasbihCount.minus(1)
                        }
                        counterTv.text = itemModel.tasbihCount.toString()
                        updateDatabase(itemModel)
                    }

                    resetRl.setOnClickListener {
                        resetData(itemModel)
                        Toast.makeText(this@CounterActivity, "Data reset.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun resetData(itemModel: ItemModel) {
        binding.apply {
            plusMinusImVBtn.setImageResource(R.drawable.add)
            switchTextTv.text = "Plus"
            itemModel.tasbihCount = 0
            counterTv.text = "0"
            itemModel.isState = true
            switchBtn.isChecked = true
            itemModel.dateTime = getDateTime()
            dateTimeTv.text = itemModel.dateTime
            updateDatabase(itemModel)
        }
    }

    private fun updateDatabase(itemModel: ItemModel) {
        lifecycleScope.launch {
            itemModel.dateTime = getDateTime()
            itemDao.update(itemModel)
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun getDateTime(): String {
        val today = Date()
        val format = SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a")
        return format.format(today)
    }
}