package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_show_recycler_item.*

class ShowRecyclerItem : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_recycler_item)

        showname.text = intent.getStringExtra("iname")
        showdesc.text = intent.getStringExtra("idesc")
        showimg.setImageResource(intent.getStringExtra("iimg").toInt())
    }
}

