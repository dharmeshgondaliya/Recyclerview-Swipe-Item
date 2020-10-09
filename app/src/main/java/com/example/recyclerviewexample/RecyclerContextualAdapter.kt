package com.example.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_contextual_items.view.*

class RecyclerContextualAdapter(var list: ArrayList<ContextualDataModel>,var clickListener: (ContextualDataModel) -> Unit,
                                                                         var longClickListener: (ContextualDataModel) -> Unit):
    RecyclerView.Adapter<RecyclerContextualAdapter.ContextualViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContextualViewHolder {
        return ContextualViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_contextual_items,parent,false))

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ContextualViewHolder, position: Int) {
        holder.bind(list[position],clickListener,longClickListener)
    }

    class ContextualViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        companion object{
            var counter: Int = 0
        }
        fun bind(condata: ContextualDataModel, clickListener: (ContextualDataModel) -> Unit,longClickListener: (ContextualDataModel) -> Unit) {
            itemView.cname.text = condata.name
            itemView.cdesc.text = condata.desc
            itemView.cimg.setImageResource(condata.img)

            itemView.ccheck.setOnClickListener {
                itemView.ccheck.visibility = View.GONE
                counter--
                longClickListener(condata)
            }

            itemView.setOnClickListener {
                if(RecyclerContextualAction.Action){
                    if(it.ccheck.visibility == View.GONE){
                        it.ccheck.visibility = View.VISIBLE
                        it.ccheck.isChecked = true
                        counter++
                    }
                    else{
                        it.ccheck.isChecked = false
                        it.ccheck.visibility= View.GONE
                        counter--
                    }
                    if(counter == 0)
                        RecyclerContextualAction.Action = false
                    longClickListener(condata)
                }
                else{
                    clickListener(condata)
                }
            }

            itemView.setOnLongClickListener {
                if(it.ccheck.visibility == View.GONE){
                    it.ccheck.visibility = View.VISIBLE
                    it.ccheck.isChecked = true
                    counter++
                }
                else{
                    it.ccheck.isChecked = false
                    it.ccheck.visibility = View.GONE
                    counter--
                }
                if (counter == 0)
                    RecyclerContextualAction.Action = false
                else
                    RecyclerContextualAction.Action = true
                longClickListener(condata)
                return@setOnLongClickListener true
            }
        }
    }
}
