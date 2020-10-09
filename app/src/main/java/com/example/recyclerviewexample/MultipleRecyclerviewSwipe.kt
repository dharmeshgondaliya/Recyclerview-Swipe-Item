package com.example.recyclerviewexample

import android.content.DialogInterface
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_multiple_recyclerview_swipe.*

class MultipleRecyclerviewSwipe : AppCompatActivity() {
    var green: ColorDrawable = ColorDrawable(Color.parseColor("#EE03FF34"))
    var orange: ColorDrawable = ColorDrawable(Color.parseColor("#F8A01F"))
    lateinit var adapter: RecyclerMulSwipeAdapter
    lateinit var list: ArrayList<DataModelMulItem>
    lateinit var deleteicon: Drawable
    lateinit var copyicon: Drawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiple_recyclerview_swipe)

        list = ArrayList()
        addItems()
        copyicon = ContextCompat.getDrawable(this,R.drawable.ic_copyback)!!
        deleteicon = ContextCompat.getDrawable(this,R.drawable.ic_deleteback)!!
        var layout = LinearLayoutManager(this)
        layout.orientation = LinearLayoutManager.VERTICAL
        recycler_mul_swipe.layoutManager = layout
        adapter = RecyclerMulSwipeAdapter(list)
        recycler_mul_swipe.adapter = adapter
        recycler_mul_swipe.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))

        var deletecallback = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT or ItemTouchHelper.UP or ItemTouchHelper.DOWN) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                Toast.makeText(applicationContext,direction.toString(),Toast.LENGTH_LONG).show()
                if (direction == 8){
                    (adapter as RecyclerMulSwipeAdapter).removeItems(viewHolder)
                }
                else if(direction == 4) {
                    (adapter as RecyclerMulSwipeAdapter).copyItem(viewHolder)
                    recycler_mul_swipe.scrollToPosition(list.size - 1)
                }
            }

            override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
                var itemView = viewHolder.itemView
                var deliconmar: Int = (itemView.height - deleteicon.intrinsicHeight) / 2
                var copyiconmar: Int = (itemView.height - copyicon.intrinsicHeight) / 2

                if(dX > 0){
                    orange.setBounds(itemView.left,itemView.top,dX.toInt(),itemView.bottom)
                    deleteicon.setBounds(itemView.left + deliconmar,itemView.top + deliconmar,itemView.left + deliconmar + deleteicon.intrinsicHeight,
                    itemView.bottom - deliconmar)
                    orange.draw(c)
                    deleteicon.draw(c)
                }
                else{
                    green.setBounds(itemView.right + dX.toInt(),itemView.top,itemView.right,itemView.bottom)
                    copyicon.setBounds(itemView.right - copyiconmar - copyicon.intrinsicHeight, itemView.top + copyiconmar, itemView.right - copyiconmar,
                        itemView.bottom - copyiconmar)
                    green.draw(c)
                    copyicon.draw(c)
                }
                c.save()
                c.restore()

                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            }

        }
        ItemTouchHelper(deletecallback).attachToRecyclerView(recycler_mul_swipe)
    }

    private fun addItems() {
        list.apply {
            add(DataModelMulItem("Samsung","Samsung Mobile",R.drawable.ic_mobile))
            add(DataModelMulItem("Samsung","Samsung Laptop",R.drawable.ic_laptop))
            add(DataModelMulItem("Apple","Apple Mobile",R.drawable.ic_mobile))
            add(DataModelMulItem("Apple","Apple Laptop",R.drawable.ic_laptop))
            add(DataModelMulItem("Asus","Asus Mobile",R.drawable.ic_mobile))
            add(DataModelMulItem("Asus","Asus Laptop",R.drawable.ic_laptop))
            add(DataModelMulItem("Acer","Acer Mobile",R.drawable.ic_mobile))
            add(DataModelMulItem("Acer","Acer Laptop",R.drawable.ic_laptop))
            add(DataModelMulItem("Lenovo","Lenovo Mobile",R.drawable.ic_mobile))
            add(DataModelMulItem("Lenovo","Lenovo Laptop",R.drawable.ic_laptop))
            add(DataModelMulItem("Nokia","Nokia Mobile",R.drawable.ic_mobile))
            add(DataModelMulItem("Dell","Dell Laptop",R.drawable.ic_laptop))
            add(DataModelMulItem("HTC","HTC Mobile",R.drawable.ic_mobile))
            add(DataModelMulItem("HP","HP Laptop",R.drawable.ic_laptop))
            add(DataModelMulItem("Mi","Mi Mobile",R.drawable.ic_mobile))
            add(DataModelMulItem("Vivo","Vivo Mobile",R.drawable.ic_mobile))
            add(DataModelMulItem("Oppo","Oppo Mobile",R.drawable.ic_mobile))
            add(DataModelMulItem("Black Berry","Black Berry Mobile",R.drawable.ic_mobile))
        }
    }

}
