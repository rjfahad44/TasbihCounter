package com.example.tasbihcounter.data


import com.example.tasbihcounter.data.dao.ItemDao
import com.example.tasbihcounter.data.model.ItemModel
import com.example.tasbihcounter.utils.AppUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class DefaultTasbihAdded {
    private val scope = CoroutineScope(Dispatchers.IO)
    fun insertDefaultTasbih(database: ItemDao?) {
        scope.launch {
            val items = ArrayList<ItemModel>()
            items.add(
                ItemModel(
                    tasbihTitle = "(আশি বছরের গুনাহ মাফ)",
                    tasbihDetails = "আল্লাহুম্মা ছাল্লি আলা সাইয়্যিদিনা মুহাম্মাদিনিন নাবিয়্যিল উম্মিই ওয়া আলা আলিহি ওয়া সাল্লিম।",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )
            items.add(
                ItemModel(
                    tasbihTitle = "(মুখের দুর্গন্ধ দূর করার উপায়)",
                    tasbihDetails = "আল্লাহুম্মা ছাল্লি ওয়া সাল্লিম আলান নবিয়্যিত ত্বাহিরি।",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )
            items.add(
                ItemModel(
                    tasbihTitle = "(ছয় লক্ষ দুরূদ শরীফ পড়ার ছাওয়াব)",
                    tasbihDetails = "আল্লাহুম্মা ছাল্লি আলা সায়্যিদিনা ওয়া মাওলানা মুহাম্মাদিন আদাদা মা ফি ইলমিল্লাহি ছালাতান্ দায়িমাতাম বিদাওয়ামি মুলকিল্লাহ।",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )
            items.add(
                ItemModel(
                    tasbihTitle = "(প্রিয় নবীর নৈকট্য লাভের উপায়)",
                    tasbihDetails = "আল্লাহুম্মা ছাল্লি আলা মুহাম্মাদিন কামা তুহিব্বু ওয়া ত্বারদ্বা লাহু।",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )
            items.add(
                ItemModel(
                    tasbihTitle = "(যেকোন সমস্যা সমাধানের জন্য পড়ুন)",
                    tasbihDetails = "ক্বল্লাত হিলাতী আন্তা ওয়াসিলাতি আদ্ রিকনি ইয়া রাসুলাল্লাহ সাল্লাল্লাহু আলাইহি ওয়াসাল্লাম।",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )
            items.add(
                ItemModel(
                    tasbihTitle = "\"ইয়া-আল্লাহ\"",
                    tasbihDetails = "যে ব্যক্তি দৈনিক ১০০ বার আল্লাহর নামটি জিকির করবে, আল্লাহপাক তার ঈমান দৃঢ় করবে। পার্থিব কোন লোভ-লালসা বা ছলনা তার ঈমান নষ্ট করতে পারবে না।",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )
            items.add(
                ItemModel(
                    tasbihTitle = "\"ইয়া-রাহমানু\"",
                    tasbihDetails = "হে অনুগ্রহকারী ও করুণাময় - প্রতিদিন নিয়মিতভাবে এ গুণবাচক নামটি ১১১১ বার যিকির করলে ইনশাআল্লাহ্ পাঠকের প্রতি সকলেই সহানুভূতিশীল থাকবে।",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )
            items.add(
                ItemModel(
                    tasbihTitle = "\"ইয়া-রাহীমু\"",
                    tasbihDetails = "হেদয়াময় ও পরম দয়ালু - প্রতিদিন নিয়মিতভাবে এ গুণবাচক নামটি ১১১বার পাঠ করলে পাঠকের মন ইনশাআল্লাহ্ বিনয়ী ও নম্র হবে।",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )
            items.add(
                ItemModel(
                    tasbihTitle = "\"ইয়া-মালিকু\"",
                    tasbihDetails = "হে মালিক প্রভূ - যে ব্যক্তি ফজরের নামাজের পর প্রত্যহ ১০০ বার \"ইয়া-মালিক\" বলবে আল্লাহতালা তাকে ধনী করে দিবেন।",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )
            items.add(
                ItemModel(
                    tasbihTitle = "\"ইয়া-কুদ্দুসু\"",
                    tasbihDetails = "হে পবিত্রতম - যে ব্যক্তি প্রত্যহ সূযাস্তের সময় এই নামটি ১০০ পাঠ করবে আল্লাহ তার মনের বিদ্বেষ দূর করে দিবেন।",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )
            items.add(
                ItemModel(
                    tasbihTitle = "\"ইয়া-সালামু\"",
                    tasbihDetails = "হে শান্তি দান কারী - যে ব্যাক্তি এই নামটি \"ইয়া-সালামু\" বেশি বেশি পাঠ করবেন আল্লাহ তার সকল প্রকার বালা মুসিবত থেকে বাঁচিয়ে রাখবেন।",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )
            items.add(
                ItemModel(
                    tasbihTitle = "\"ইয়া-মুমিনু\"",
                    tasbihDetails = "হে পরম বিশ্বাসী - প্রতিদিন নিয়মিত ভাবেএ পবিত্র নামটি অধিক পরিমানে পাঠকারী ব্যক্তি শয়তানের ধোঁকা থেকে মুক্তি লাভ করবে।",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )
            items.add(
                ItemModel(
                    tasbihTitle = "\"ইয়া-মুহাইমিনু\"",
                    tasbihDetails = "হে রক্ষাকর্তা ও পরম সাহসী - যে ব্যক্তি গোসল করে দুই রাকাত নামাজ পড়ে খাস দিলে ১০০ বার \"ইয়া-মুহাইমিনু\" এই নামটি পড়বে আল্লাহ তালা তার মনের ভিতর থেকে সকল প্রকার ভয় দূর করে দিবেন। মনে সাহস বৃদ্ধি পাবে।",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )
            items.add(
                ItemModel(
                    tasbihTitle = "\"ইয়া-আযীযু\"",
                    tasbihDetails = "হে পরাক্রমশালী - যে ব্যক্তি ৪০ দিন পর্যন্ত একাধারে ৭৫ বার \"ইয়া-আযিযু\" পড়বে আল্লাহপাক তাকে সম্মানিত ও অমুখাপেক্ষী করে দিবেন।",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )
            items.add(
                ItemModel(
                    tasbihTitle = "\"ইয়া-জব্বারু\"",
                    tasbihDetails = "হে অসীম ক্ষমতাশালী - কেউ যদি উক্তি নামটি হাতের আংটির পাথরে খোদাই করে ব্যবহার করে, তবে সে যেখানেই গমন করুক না কে লোকে তাকে সম্মান করবে।",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )
            items.add(
                ItemModel(
                    tasbihTitle = "\"ইয়া-মুতাকাব্বিরু\"",
                    tasbihDetails = "হে মহা গৌরবান্বিত - নিয়মিত ভাবে এ পবিত্র গুণবাচক নামটি ৬৯৫বার পাঠ করলে পাঠকের মানসম্মান ও ব্যক্তিত্ব বৃদ্ধি পাবে।",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )
            items.add(
                ItemModel(
                    tasbihTitle = "\"ইয়া-খলিক্কু\"",
                    tasbihDetails = "হে সৃজনকারী বা সৃষ্টিকর্তা - যে ব্যক্তি একাধারে ৭ দিন পর্যন্ত এই নামটি সদা সর্বদা জিকির করিবে, আল্লাহ তালা তাকে বিপদ-আপদ থেকে মুক্ত রাখবেন।",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )
            items.add(
                ItemModel(
                    tasbihTitle = "\"ইয়া মালিকু - ইয়া কুদ্দুসু।\"",
                    tasbihDetails = "",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )
            items.add(
                ItemModel(
                    tasbihTitle = "\"লা- হাওলা ওয়ালা কুওয়াতা ইল্লা বিল্লাহিল আলিয়্যিল আযীম।\"",
                    tasbihDetails = "",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )
            items.add(
                ItemModel(
                    tasbihTitle = "\"লা হাওলা ওয়ালা কুওয়াতা ইল্লা বিল্লাহ।\"",
                    tasbihDetails = "",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )
            items.add(
                ItemModel(
                    tasbihTitle = "\"আসতাগফিরুল্লাহ।\"",
                    tasbihDetails = "",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )
            items.add(
                ItemModel(
                    tasbihTitle = "\"আল্লাহ হুয়াকবার।\"",
                    tasbihDetails = "",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )
            items.add(
                ItemModel(
                    tasbihTitle = "\"আলহামদুলিল্লাহ্।\"",
                    tasbihDetails = "",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )
            items.add(
                ItemModel(
                    tasbihTitle = "\"সুবহান আল্লাহ্।\"",
                    tasbihDetails = "",
                    tasbihCount = 0,
                    isState = true,
                    isSelectState = false,
                    dateTime = AppUtils.getCurrentDateTime()
                )
            )

            database?.saveItems(items)
        }
    }
}