package com.livedatasexample.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.livedatasexample.databinding.ListListBinding
import com.livedatasexample.model.Meme
import com.livedatasexample.model.PhotosResponse

class MemeAdapter(
    val context: Context,
    ) : RecyclerView.Adapter<MemeAdapter.MemeViewHolder>() {

    private val list = mutableListOf<PhotosResponse>()

    inner class MemeViewHolder( val binding : ListListBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeViewHolder {
       val binding = ListListBinding.inflate(LayoutInflater.from(parent.context) ,parent , false)
        return MemeViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return list?.size ?:0
    }

    override fun onBindViewHolder(holder: MemeViewHolder, position: Int) {
          holder.binding.tvTitle.text = list?.get(position)?.title ?: ""
    }

    fun addItems(newItems: List<PhotosResponse>) {
        val start = list?.size ?:-1
        list?.addAll(newItems)
        notifyItemRangeInserted(start, newItems.size)
    }

    fun clearAll() {
        list?.clear()
        notifyDataSetChanged()
    }
}