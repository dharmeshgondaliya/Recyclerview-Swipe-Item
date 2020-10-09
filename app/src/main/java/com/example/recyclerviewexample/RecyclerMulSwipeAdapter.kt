package com.example.recyclerviewexample

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_multiple_items.view.*
import java.util.zip.Inflater

class RecyclerMulSwipeAdapter(var list: ArrayList<DataModelMulItem>): RecyclerView.Adapter<RecyclerMulSwipeAdapter.SwipeMulviewholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwipeMulviewholder {
        return SwipeMulviewholder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_multiple_items,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SwipeMulviewholder, position: Int) {
        holder.bind(list[position])
    }

    fun removeItems(viewHolder: RecyclerView.ViewHolder){
        list.removeAt(viewHolder.adapterPosition)
        notifyItemRemoved(viewHolder.adapterPosition)
    }

    fun copyItem(viewHolder: RecyclerView.ViewHolder) {
        list.add(list.size,list[viewHolder.adapterPosition])
        notifyItemInserted(list.size)
    }

    class SwipeMulviewholder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(dataitem: DataModelMulItem) {
            itemView.miimg.setImageResource(dataitem.img)
            itemView.miname.text = dataitem.name
            itemView.midescription.text = dataitem.description
        }
    }
}