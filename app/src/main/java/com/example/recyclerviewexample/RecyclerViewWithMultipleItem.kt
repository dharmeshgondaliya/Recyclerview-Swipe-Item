package com.example.recyclerviewexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view_with_multiple_item.*

class RecyclerViewWithMultipleItem : AppCompatActivity(){

    lateinit var list: ArrayList<DataModelMulItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_with_multiple_item)
        list = ArrayList<DataModelMulItem>()
        addItems()
        val layout = LinearLayoutManager(this)
        layout.orientation = LinearLayoutManager.VERTICAL
        recycler_mul_item.layoutManager = layout
        recycler_mul_item.adapter = RecyclerMulItemAdapter(applicationContext,list,{person-> personOnItemCLick(person)})
    }

    private fun addItems() {
        list.add(DataModelMulItem("Samsung","Samsung Mobile",R.drawable.ic_mobile))
        list.add(DataModelMulItem("Samsung","Samsung Laptop",R.drawable.ic_laptop))
        list.add(DataModelMulItem("Apple","Apple Mobile",R.drawable.ic_mobile))
        list.add(DataModelMulItem("Apple","Apple Laptop",R.drawable.ic_laptop))
        list.add(DataModelMulItem("Asus","Asus Mobile",R.drawable.ic_mobile))
        list.add(DataModelMulItem("Asus","Asus Laptop",R.drawable.ic_laptop))
        list.add(DataModelMulItem("Acer","Acer Mobile",R.drawable.ic_mobile))
        list.add(DataModelMulItem("Acer","Acer Laptop",R.drawable.ic_laptop))
        list.add(DataModelMulItem("Lenovo","Lenovo Mobile",R.drawable.ic_mobile))
        list.add(DataModelMulItem("Lenovo","Lenovo Laptop",R.drawable.ic_laptop))
        list.add(DataModelMulItem("Nokia","Nokia Mobile",R.drawable.ic_mobile))
        list.add(DataModelMulItem("Dell","Dell Laptop",R.drawable.ic_laptop))
        list.add(DataModelMulItem("HTC","HTC Mobile",R.drawable.ic_mobile))
        list.add(DataModelMulItem("HP","HP Laptop",R.drawable.ic_laptop))
        list.add(DataModelMulItem("Mi","Mi Mobile",R.drawable.ic_mobile))
        list.add(DataModelMulItem("Vivo","Vivo Mobile",R.drawable.ic_mobile))
        list.add(DataModelMulItem("Oppo","Oppo Mobile",R.drawable.ic_mobile))
        list.add(DataModelMulItem("Black Berry","Black Berry Mobile",R.drawable.ic_mobile))
    }

    fun personOnItemCLick(person: DataModelMulItem){
        Toast.makeText(applicationContext,person.name,Toast.LENGTH_LONG).show()
        var intent = Intent(this,ShowRecyclerItem::class.java)
        intent.putExtra("iname",person.name)
        intent.putExtra("idesc",person.description)
        intent.putExtra("iimg",person.img.toString())
        startActivity(intent)
    }

}
