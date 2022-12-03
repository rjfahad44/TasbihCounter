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
            items.add(ItemModel("(আশি বছরের গুনাহ মাফ) - \"আল্লাহুম্মা ছাল্লি আলা সাইয়্যিদিনা মুহাম্মাদিনিন নাবিয়্যিল উম্মিই ওয়া আলা আলিহি ওয়া সাল্লিম।\"", 0, true, false, AppUtils.getCurrentDateTime()))
            items.add(ItemModel("(মুখের দুর্গন্ধ দূর করার উপায়) - \"আল্লাহুম্মা ছাল্লি ওয়া সাল্লিম আলান নবিয়্যিত ত্বাহিরি।\"", 0, true, false, AppUtils.getCurrentDateTime()))
            items.add(ItemModel("(ছয় লক্ষ দুরূদ শরীফ পড়ার ছাওয়াব) - \"আল্লাহুম্মা ছাল্লি আলা সায়্যিদিনা ওয়া মাওলানা মুহাম্মাদিন আদাদা মা ফি ইলমিল্লাহি ছালাতান্ দায়িমাতাম বিদাওয়ামি মুলকিল্লাহ।\"", 0, true, false, AppUtils.getCurrentDateTime()))
            items.add(ItemModel("(প্রিয় নবীর নৈকট্য লাভের উপায়) - \"আল্লাহুম্মা ছাল্লি আলা মুহাম্মাদিন কামা তুহিব্বু ওয়া ত্বারদ্বা লাহু।\"", 0, true, false, AppUtils.getCurrentDateTime()))
            items.add(ItemModel("(যেকোন সমস্যা সমাধানের জন্য পড়ুন) - \"ক্বল্লাত হিলাতী আন্তা ওয়াসিলাতি আদ্ রিকনি ইয়া রাসুলাল্লাহ সাল্লাল্লাহু আলাইহি ওয়াসাল্লাম।\"", 0, true, false, AppUtils.getCurrentDateTime()))
            items.add(ItemModel("\"ইয়া-আল্লাহ\" - (যে ব্যক্তি দৈনিক ১০০ বার আল্লাহর নামটি জিকির করবে, আল্লাহপাক তার ঈমান দৃঢ় করবে। পার্থিব কোন লোভ-লালসা বা ছলনা তার ঈমান নষ্ট করতে পারবে না।)", 0, true, false, AppUtils.getCurrentDateTime()))
            items.add(ItemModel("\"ইয়া-রাহমানু\" - (হে অনুগ্রহকারী ও করুণাময়) (প্রতিদিন নিয়মিতভাবে এ গুণবাচক নামটি ১১১১ বার যিকির করলে ইনশাআল্লাহ্ পাঠকের প্রতি সকলেই সহানুভূতিশীল থাকবে।)", 0, true, false, AppUtils.getCurrentDateTime()))
            items.add(ItemModel("\"ইয়া-রাহীমু\" - (হেদয়াময় ও পরম দয়ালু) (প্রতিদিন নিয়মিতভাবে এ গুণবাচক নামটি ১১১বার পাঠ করলে পাঠকের মন ইনশাআল্লাহ্ বিনয়ী ও নম্র হবে।)", 0, true, false, AppUtils.getCurrentDateTime()))
            items.add(ItemModel("\"ইয়া-মালিকু\" - (হে মালিক প্রভূ) (যে ব্যক্তি ফজরের নামাজের পর প্রত্যহ ১০০ বার ‘ইয়া-মালিক’ বলবে আল্লাহতালা তাকে ধনী করে দিবেন।)", 0, true, false, AppUtils.getCurrentDateTime()))
            items.add(ItemModel("\"ইয়া-কুদ্দুসু\" - (হে পবিত্রতম) (যে ব্যক্তি প্রত্যহ সূযাস্তের সময় এই নামটি ১০০ পাঠ করবে আল্লাহ তার মনের বিদ্বেষ দূর করে দিবেন।)", 0, true, false, AppUtils.getCurrentDateTime()))
            items.add(ItemModel("\"ইয়া-সালামু\" - (হে শান্তি দান কারী) (যে ব্যাক্তি এই নামটি “ইয়া-সালামু” বেশি বেশি পাঠ করবেন আল্লাহ তার সকল প্রকার বালা মুসিবত থেকে বাঁচিয়ে রাখবেন।)", 0, true, false, AppUtils.getCurrentDateTime()))
            items.add(ItemModel("\"ইয়া-মু’মিনু\" - (হে পরম বিশ্বাসী) (প্রতিদিন নিয়মিত ভাবেএ পবিত্র নামটি অধিক পরিমানে পাঠকারী ব্যক্তি শয়তানের ধোঁকা থেকে মুক্তি লাভ করবে।)", 0, true, false, AppUtils.getCurrentDateTime()))
            items.add(ItemModel("\"ইয়া-মুহাইমিনু\" - (হে রক্ষাকর্তা ও পরম সাহসী) (যে ব্যক্তি গোসল করে দুই রাকাত নামাজ পড়ে খাস দিলে ১০০ বার “ইয়া-মুহাইমিনু” এই নামটি পড়বে আল্লাহ তালা তার মনের ভিতর থেকে সকল প্রকার ভয় দূর করে দিবেন। মনে সাহস বৃদ্ধি পাবে।)", 0, true, false, AppUtils.getCurrentDateTime()))
            items.add(ItemModel("\"ইয়া-আযীযু\" - (হে পরাক্রমশালী) (যে ব্যক্তি ৪০ দিন পর্যন্ত একাধারে ৭৫ বার “ইয়া-আযিযু” পড়বে আল্লাহপাক তাকে সম্মানিত ও অমুখাপেক্ষী করে দিবেন।)", 0, true, false, AppUtils.getCurrentDateTime()))
            items.add(ItemModel("\"ইয়া-জব্বারু\" - (হে অসীম ক্ষমতাশালী) (কেউ যদি উক্তি নামটি হাতের আংটির পাথরে খোদাই করে ব্যবহার করে, তবে সে যেখানেই গমন করুক না কে লোকে তাকে সম্মান করবে।)", 0, true, false, AppUtils.getCurrentDateTime()))
            items.add(ItemModel("\"ইয়া-মুতাকাব্বিরু\" - (হে মহা গৌরবান্বিত) (নিয়মিত ভাবে এ পবিত্র গুণবাচক নামটি ৬৯৫বার পাঠ করলে পাঠকের মানসম্মান ও ব্যক্তিত্ব বৃদ্ধি পাবে।)", 0, true, false, AppUtils.getCurrentDateTime()))
            items.add(ItemModel("\"ইয়া-খলিক্কু\" - (হে সৃজনকারী বা সৃষ্টিকর্তা) (যে ব্যক্তি একাধারে ৭ দিন পর্যন্ত এই নামটি সদা সর্বদা জিকির করিবে, আল্লাহ তালা তাকে বিপদ-আপদ থেকে মুক্ত রাখবেন।)", 0, true, false, AppUtils.getCurrentDateTime()))
            items.add(ItemModel("\"ইয়া মালিকু - ইয়া কুদ্দুসু।\"", 0, true, false, AppUtils.getCurrentDateTime()))
            items.add(ItemModel("\"লা- হাওলা ওয়ালা কুওয়াতা ইল্লা বিল্লাহিল আলিয়্যিল আযীম।\"", 0, true, false, AppUtils.getCurrentDateTime()))
            items.add(ItemModel("\"লা হাওলা ওয়ালা কুওয়াতা ইল্লা বিল্লাহ।\"", 0, true, false, AppUtils.getCurrentDateTime()))
            items.add(ItemModel("\"আসতাগফিরুল্লাহ।\"", 0, true, false, AppUtils.getCurrentDateTime()))
            items.add(ItemModel("\"আল্লাহ হুয়াকবার।\"", 0, true, false, AppUtils.getCurrentDateTime()))
            items.add(ItemModel("\"আলহামদুলিল্লাহ্।\"", 0, true, false, AppUtils.getCurrentDateTime()))
            items.add(ItemModel("\"সুবহান আল্লাহ্।\"", 0, true, false, AppUtils.getCurrentDateTime()))












            database?.saveItems(items)
        }
        if (scope.isActive){

        }
    }
}