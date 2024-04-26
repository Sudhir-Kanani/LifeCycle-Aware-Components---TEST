package com.ads.datae.DiftUtil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ads.lifecycleawarecomponents.R

class ProgramicAdapter :ListAdapter<ProgramicItem,ProgramicAdapter.ProgramicViewHolder>(DiftUtil()) {

    class ProgramicViewHolder(view:View) : RecyclerView.ViewHolder(view)
    {
        val txt_init = view.findViewById<TextView>(R.id.txt_init)
        val txt_name = view.findViewById<TextView>(R.id.txt_name)

        fun bind(programicItem: ProgramicItem)
        {
            txt_init.text = programicItem.init
            txt_name.text = programicItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.program_item,parent,false)
        return  ProgramicViewHolder(view);
    }

    override fun onBindViewHolder(holder: ProgramicViewHolder, position: Int) {
       val item = getItem(position)
        holder.bind(item)
    }
    class DiftUtil: DiffUtil.ItemCallback<ProgramicItem>()
    {
        override fun areItemsTheSame(oldItem: ProgramicItem, newItem: ProgramicItem): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: ProgramicItem, newItem: ProgramicItem): Boolean {
        return oldItem ==newItem
        }

    }
}

