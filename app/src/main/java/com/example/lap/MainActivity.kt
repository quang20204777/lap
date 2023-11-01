package com.example.lap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var emailAdapter: EmailAdapter
    private var emailList = ArrayList<EmailModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tạo dữ liệu giả
        generateFakeData()

        listView = findViewById(R.id.listView)
        emailAdapter = EmailAdapter(emailList)
        listView.adapter = emailAdapter
    }

    private fun generateFakeData() {
        // Tạo và thêm dữ liệu giả vào danh sách emailList
        emailList.add(
            EmailModel(
                "Ronaldo",
                "kkaldmaksdkakdádasda",
                "avatar11",
                "11:00 AM",
                true
            )
        )
        emailList.add(
            EmailModel(
                "Messi",
                "ádsadadwdasdad",
                "avatar12",
                "12:20 AM",
                false
            )
        )
        emailList.add(
            EmailModel(
                "Minion",
                "ádkadklasdadssad",
                "avatar13",
                "Yesterday",
                true
            )
        )
        emailList.add(
            EmailModel(
                "JamesGrealish",
                "Review the budget report",
                "avatar14",
                "2h ago",
                false
            )
        )
        emailList.add(EmailModel("NaaGreen", "Project update", "avatar7", "11:45 AM", false))
        emailList.add(EmailModel("KenichaelBrown", "New product launch", "avatar8", "12:30 PM", true))
        emailList.add(EmailModel("SuaresMiller", "Weekend plans", "avatar9", "Yesterday", false))
        emailList.add(
            EmailModel(
                "GoWilson",
                "Hẹn gặp l;akio",
                "avatar10",
                "1 days ago",
                true
            )
        )
        emailList.add(EmailModel("Jax", "Hello there!", "avatar3", "10:15 AM", true))
        emailList.add(EmailModel("Eres", "Meeting tomorrow", "avatar4", "Yesterday", false))
        emailList.add(
            EmailModel(
                "Doraemon",
                "Don't forget the deadline",
                "avatar5",
                "2 days ago",
                false
            )
        )
        emailList.add(EmailModel("Gaos", "Vacation plans", "avatar6", "Last week", true))
        // Thêm các mục email khác tương tự ở đây
    }
}