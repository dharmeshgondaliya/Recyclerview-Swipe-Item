package com.example.recyclerviewexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.simple_recycler_items.view.*

class SimpleRecyclerAdapter(val context: Context, val list: Array<String>): RecyclerView.Adapter<MyHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.simple_recycler_items,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(list[position])
    }


}
class MyHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    fun bind(item: String){
        itemView.simple_text.text = item
    }
}