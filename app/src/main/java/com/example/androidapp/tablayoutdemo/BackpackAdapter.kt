package com.example.androidapp.tablayoutdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidapp.R
import kotlinx.android.synthetic.main.item_view_backpack.view.*

class BackpackAdapter(private val BackpackList: ArrayList<Backpack>) : RecyclerView.Adapter<BackpackAdapter.BackpackViewHolder>() {

    class BackpackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BackpackViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_backpack, parent, false)
        return BackpackViewHolder(view)
    }

    override fun getItemCount(): Int = BackpackList.size

    override fun onBindViewHolder(holder: BackpackViewHolder, position: Int) {
        val backpack = BackpackList[position]
        holder.itemView.nameIV.setImageResource(backpack.image)
        holder.itemView.nameTV.text = backpack.title1
        holder.itemView.validTV.text = backpack.title2
        holder.itemView.dateTV.text = backpack.title3
    }
}