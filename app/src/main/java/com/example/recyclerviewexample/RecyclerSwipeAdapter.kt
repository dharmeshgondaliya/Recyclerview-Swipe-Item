package com.example.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.recycler_swipe_item.view.*

class RecyclerSwipeAdapter(var list: ArrayList<String>):
    RecyclerView.Adapter<RecyclerSwipeAdapter.SwipeViewHolder>() {

    var removePosition: Int = 0
    var removeItem: String = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwipeViewHolder {
        return SwipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_swipe_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SwipeViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun removeItem(viewHolder: RecyclerView.ViewHolder){
        removePosition = viewHolder.adapterPosition
        removeItem = list[viewHolder.adapterPosition]

        list.removeAt(viewHolder.adapterPosition)
        notifyItemRemoved(viewHolder.adapterPosition)

        Snackbar.make(viewHolder.itemView,"${this.removeItem} deleted.",Snackbar.LENGTH_LONG).setAction("UNDO"){
            list.add(removePosition,this.removeItem)
            notifyItemInserted(removePosition)
        }.show()
    }

    class SwipeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(s: String) {
            itemView.swipe_text.text = s
        }

    }
}