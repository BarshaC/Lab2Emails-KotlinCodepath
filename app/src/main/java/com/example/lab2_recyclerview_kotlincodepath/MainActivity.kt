package com.example.lab2_recyclerview_kotlincodepath

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2_recyclerview_kotlincodepath.EmailFetcher.Companion.getEmails

class MainActivity : AppCompatActivity() {
    lateinit var emails: List<Email>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rvEmails = findViewById<RecyclerView>(R.id.emailsRv)
        emails = EmailFetcher.getEmails()       //fetch list of emails
        val adapter = EmailAdapter(emails)      //creating adapter passing into list of emails
        rvEmails.adapter = adapter          //attach the adapter to the Recycler View to populate email items
        rvEmails.layoutManager = LinearLayoutManager(this)
        findViewById<Button>(R.id.loadMoreBtn).setOnClickListener {
            val newEmails = EmailFetcher.getNext5Emails()
            (emails as MutableList<Email>).addAll(newEmails)
            adapter.notifyDataSetChanged()

        }

    }
}