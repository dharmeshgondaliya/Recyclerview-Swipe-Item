package com.example.recyclerviewexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_multiple_items.view.*

class RecyclerMulItemAdapter(var context: Context, var list: ArrayList<DataModelMulItem>,val clickListener: (DataModelMulItem) -> Unit):
    RecyclerView.Adapter<RecyclerMulItemAdapter.MulAdapter>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MulAdapter {
        return MulAdapter(LayoutInflater.from(context).inflate(R.layout.recycler_multiple_items,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MulAdapter, position: Int) {
        holder.bind(list[position],clickListener)
    }

    class MulAdapter(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(person: DataModelMulItem,clickListener: (DataModelMulItem) -> Unit){
            itemView.miname.text = person.name
            itemView.midescription.text = person.description
            itemView.miimg.setImageResource(person.img)
            itemView.setOnClickListener { clickListener(person) }
        }
    }
}
