package com.example.recyclerviewexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        simple_recycler_view.setOnClickListener {
            startActivity(Intent(this,SimpleRecyclerView::class.java))
        }
        recycler_multiple_item.setOnClickListener {
            startActivity(Intent(this,RecyclerViewWithMultipleItem::class.java))
        }
        recycler_contextual_action.setOnClickListener {
            startActivity(Intent(this,RecyclerContextualAction::class.java))
        }
        recycler_swipe_button.setOnClickListener {
            startActivity(Intent(this,RecyclerSwipe::class.java))
        }
        recycler_swipe_mul.setOnClickListener {
            startActivity(Intent(this,MultipleRecyclerviewSwipe::class.java))
        }
    }
}
