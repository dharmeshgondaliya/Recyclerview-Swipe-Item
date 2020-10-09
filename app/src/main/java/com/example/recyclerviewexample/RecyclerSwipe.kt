package com.example.recyclerviewexample

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_swipe.*

class RecyclerSwipe : AppCompatActivity() {

    lateinit var list: ArrayList<String>
    lateinit var layout: LinearLayoutManager
    lateinit var adapter: RecyclerView.Adapter<*>
    var swipeBackground: ColorDrawable = ColorDrawable(Color.parseColor("#FF0000"))
    lateinit var deleteIcon: Drawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_swipe)

        addItems()
        list = ArrayList()
        deleteIcon = ContextCompat.getDrawable(this,R.drawable.ic_delete)!!
        layout = LinearLayoutManager(this)
        adapter = RecyclerSwipeAdapter(list)
        layout.orientation = LinearLayoutManager.VERTICAL
        recyclerview_swipe.layoutManager = layout
        recyclerview_swipe.adapter = adapter
        recyclerview_swipe.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))

        val itemTouchHelperCallback = object: ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, position: Int) {
                (adapter as RecyclerSwipeAdapter).removeItem(viewHolder)
            }

            override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float,
                actionState: Int, isCurrentlyActive: Boolean) {
                val itemView = viewHolder.itemView
                val iconMargin = (itemView.height - deleteIcon.intrinsicHeight) / 2

                if(dX > 0){
                    swipeBackground.setBounds(itemView.left,itemView.top,dX.toInt(),itemView.bottom)
                    deleteIcon.setBounds(itemView.left + iconMargin, itemView.top + iconMargin, itemView.left + iconMargin + deleteIcon.intrinsicHeight,
                    itemView.bottom - iconMargin)
                }else{
                    swipeBackground.setBounds(itemView.right + dX.toInt(),itemView.top,itemView.right,itemView.bottom)
                    deleteIcon.setBounds(itemView.right - iconMargin - deleteIcon.intrinsicHeight, itemView.top + iconMargin, itemView.right - iconMargin,
                        itemView.bottom - iconMargin)
                }
                swipeBackground.draw(c)

                c.save()

                /*if(dX > 0)
                    c.clipRect(itemView.right,itemView.top,dX.toInt(),itemView.bottom)
                 else
                    c.clipRect(itemView.right + dX.toInt(),itemView.top,itemView.right,itemView.bottom)
                */
                deleteIcon.draw(c)

                c.restore()

                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            }
        }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recyclerview_swipe)
    }

    private fun addItems() {
        list.apply {
            add("Samsung")
            add("Apple")
            add("Nokia")
            add("HTC")
            add("LG")
            add("Motorola")
            add("Acer")
            add("Asus")
            add("Dell")
            add("Lenovo")
            add("Blackberry")
            add("Oppo")
            add("Vivo")
            add("OnePlus")
            add("Mi")
        }
    }


}
