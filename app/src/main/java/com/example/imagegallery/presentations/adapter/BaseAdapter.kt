package com.example.imagegallery.presentations.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.imagegallery.R
import com.example.imagegallery.databinding.ActivityBaseBinding
import com.example.imagegallery.databinding.ImageViewholderBinding
import com.example.imagegallery.network.response.Pixabay
import com.example.imagegallery.presentations.fragments.BottomSheetFragment

class BaseAdapter(
     val list: ArrayList<Pixabay.Hit>,
     val listener:OnItemClickListener
): RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {

    inner class BaseViewHolder(var binding: ImageViewholderBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view:ImageViewholderBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.image_viewholder,parent,false)
        return BaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val data = list[position]
        holder.binding.apply {
            item = data
            listenerClick = listener
            executePendingBindings()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addItems(listItems: ArrayList<Pixabay.Hit>){
        list.addAll(listItems)
        notifyDataSetChanged()
    }
    interface OnItemClickListener{
        fun onItemClick(item : Pixabay.Hit)
    }
}