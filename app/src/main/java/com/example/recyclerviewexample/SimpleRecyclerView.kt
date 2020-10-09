package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_simple_recycler_view.*

class SimpleRecyclerView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_recycler_view)

        val list = arrayOf("Samsung","Apple","Nokia","HTC","LG","Motorola","Acer","Asus",
             "Dell","Lenovo","Blackberry","Oppo","Vivo","Google","OnePlus","Mi")

        val layout = LinearLayoutManager(this)
        layout.orientation = LinearLayoutManager.VERTICAL
        simple_recyclerview.layoutManager = layout
        val adapter = SimpleRecyclerAdapter(this,list)
        simple_recyclerview.adapter = adapter
    }
}
