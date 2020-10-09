package com.example.recyclerviewexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_contextual_action.*

class RecyclerContextualAction : AppCompatActivity() {

    companion object{
        var Action: Boolean = false
    }
    lateinit var list: ArrayList<ContextualDataModel>
    lateinit var selectedlist: ArrayList<ContextualDataModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_contextual_action)
        setSupportActionBar(toolbar)
        toolbar_back.visibility = View.GONE
        toolbar_image.visibility = View.GONE

        toolbar_text.text = "Select Items"
        list = ArrayList<ContextualDataModel>()
        selectedlist = ArrayList<ContextualDataModel>()
        addData()

        toolbar_back.setOnClickListener {
            selectedlist.clear()
            RecyclerContextualAdapter.ContextualViewHolder.counter = 0
            Action = false
            toolbar_back.visibility = View.GONE
            toolbar_image.visibility = View.GONE
            RefreshData()
            toolbar_text.text = "Select Items"
        }
        toolbar_image.setOnClickListener {
            for (i in 0..selectedlist.size - 1){
                list.remove(selectedlist[i])
            }
            selectedlist.clear()
            RecyclerContextualAdapter.ContextualViewHolder.counter = 0
            Action = false
            toolbar_back.visibility = View.GONE
            toolbar_image.visibility = View.GONE
            RefreshData()
            toolbartext()
        }

        var layout = LinearLayoutManager(this)
        layout.orientation = LinearLayoutManager.VERTICAL
        contectual_recycler.layoutManager = layout
        RefreshData()
    }

    fun toolbartext(){
        toolbar_text.text = "${RecyclerContextualAdapter.ContextualViewHolder.counter.toString()} Item Select"
    }

    private fun RefreshData(){
        contectual_recycler.adapter = RecyclerContextualAdapter(list,{click-> OnItemClick(click)},{longclick-> OnItemLongClickListener(longclick)})
    }

    private fun OnItemClick(click: ContextualDataModel) {
        if(RecyclerContextualAdapter.ContextualViewHolder.counter == 0){
            toolbar_text.text = "Select Items"
            toolbar_back.visibility = View.GONE
            toolbar_image.visibility = View.GONE

            var intent = Intent(this,ShowRecyclerItem::class.java)
            intent.putExtra("iname",click.name)
            intent.putExtra("idesc",click.desc)
            intent.putExtra("iimg",click.img.toString())
            startActivity(intent)
            return
        }
        if(RecyclerContextualAdapter.ContextualViewHolder.counter >= 1){
            toolbartext()
            toolbar_back.visibility = View.VISIBLE
            toolbar_image.visibility = View.VISIBLE
            addselected(click)
            return
        }
    }

    private fun OnItemLongClickListener(longclick: ContextualDataModel){
        if(RecyclerContextualAdapter.ContextualViewHolder.counter == 0){
            toolbar_text.text = "Select Items"
            toolbar_back.visibility = View.GONE
            toolbar_image.visibility = View.GONE
            return
        }
        if(RecyclerContextualAdapter.ContextualViewHolder.counter >= 1){
            toolbartext()
            toolbar_back.visibility = View.VISIBLE
            toolbar_image.visibility = View.VISIBLE
            addselected(longclick)
            return
        }
    }

    private fun addselected(item: ContextualDataModel){
        if(item in selectedlist){
            selectedlist.remove(item)
        }else{
            selectedlist.add(item)
        }
    }

    private fun addData() {
        list.add(ContextualDataModel("Samsung","Samsung Mobile",R.drawable.ic_mobile))
        list.add(ContextualDataModel("Samsung","Samsung Laptop",R.drawable.ic_laptop))
        list.add(ContextualDataModel("Apple","Apple Mobile",R.drawable.ic_mobile))
        list.add(ContextualDataModel("Apple","Apple Laptop",R.drawable.ic_laptop))
        list.add(ContextualDataModel("Asus","Asus Mobile",R.drawable.ic_mobile))
        list.add(ContextualDataModel("Asus","Asus Laptop",R.drawable.ic_laptop))
        list.add(ContextualDataModel("Acer","Acer Mobile",R.drawable.ic_mobile))
        list.add(ContextualDataModel("Acer","Acer Laptop",R.drawable.ic_laptop))
        list.add(ContextualDataModel("Lenovo","Lenovo Mobile",R.drawable.ic_mobile))
        list.add(ContextualDataModel("Lenovo","Lenovo Laptop",R.drawable.ic_laptop))
        list.add(ContextualDataModel("Nokia","Nokia Mobile",R.drawable.ic_mobile))
        list.add(ContextualDataModel("Dell","Dell Laptop",R.drawable.ic_laptop))
        list.add(ContextualDataModel("HTC","HTC Mobile",R.drawable.ic_mobile))
        list.add(ContextualDataModel("HP","HP Laptop",R.drawable.ic_laptop))
        list.add(ContextualDataModel("Mi","Mi Mobile",R.drawable.ic_mobile))
        list.add(ContextualDataModel("Vivo","Vivo Mobile",R.drawable.ic_mobile))
        list.add(ContextualDataModel("Oppo","Oppo Mobile",R.drawable.ic_mobile))
        list.add(ContextualDataModel("Black Berry","Black Berry Mobile",R.drawable.ic_mobile))
    }
}
