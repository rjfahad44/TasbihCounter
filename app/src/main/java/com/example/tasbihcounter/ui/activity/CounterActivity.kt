package com.example.tasbihcounter.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.tasbihcounter.data.model.ItemModel
import com.example.tasbihcounter.R
import com.example.tasbihcounter.databinding.ActivityCounterBinding
import com.example.tasbihcounter.utils.AppUtils
import com.example.tasbihcounter.viewmodel.AppViewModel

class CounterActivity : AppCompatActivity() {

    lateinit var binding: ActivityCounterBinding
    lateinit var viewModel: AppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize()
    }

    private fun initialize() {
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]

        binding.apply {
            title.text = intent.extras!!.getString("title")
            title.setSingleLine()
            title.ellipsize = TextUtils.TruncateAt.MARQUEE
            title.marqueeRepeatLimit = -1
            title.isSelected = true
        }

        val id: Int = intent.extras!!.getInt("id")

        viewModel.searchItemById(id).observe(this) { itemModel ->
            binding.apply {
                counterTv.text = itemModel.tasbihCount.toString()
                dateTimeTv.text = itemModel.dateTime
                switchBtn.isChecked = itemModel.isState
                if (itemModel.isState) {
                    plusMinusImVBtn.setImageResource(R.drawable.add)
                    switchTextTv.text = getString(R.string.add)
                } else {
                    plusMinusImVBtn.setImageResource(R.drawable.minus)
                    switchTextTv.text = getString(R.string.subtract)
                }
                switchBtn.setOnCheckedChangeListener { _, boolean ->
                    itemModel.isState = !itemModel.isState
                    updateDatabase(itemModel)
                    if (itemModel.isState) {
                        plusMinusImVBtn.setImageResource(R.drawable.add)
                        switchTextTv.text = getString(R.string.add)
                    } else {
                        plusMinusImVBtn.setImageResource(R.drawable.minus)
                        switchTextTv.text = getString(R.string.subtract)
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

    private fun resetData(itemModel: ItemModel) {
        binding.apply {
            plusMinusImVBtn.setImageResource(R.drawable.add)
            switchTextTv.text = getString(R.string.add)
            itemModel.tasbihCount = 0
            counterTv.text = "0"
            itemModel.isState = true
            switchBtn.isChecked = true
            dateTimeTv.text = itemModel.dateTime
        }
        updateDatabase(itemModel)
    }

    private fun updateDatabase(itemModel: ItemModel) {
        itemModel.dateTime = AppUtils.getCurrentDateTime()
        viewModel.updateItem(itemModel)
    }
}