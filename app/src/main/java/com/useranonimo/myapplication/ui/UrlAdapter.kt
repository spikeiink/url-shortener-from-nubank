package com.useranonimo.myapplication.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.useranonimo.myapplication.R
import com.useranonimo.myapplication.data.UrlResponse

class UrlAdapter(
    private var items: List<UrlResponse>
) : RecyclerView.Adapter<UrlAdapter.UrlViewHolder>() {

    inner class UrlViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvShortUrl: TextView = itemView.findViewById(R.id.tvShortUrl)
        private val tvOriginalUrl: TextView = itemView.findViewById(R.id.tvOriginalUrl)

        fun bind(item: UrlResponse) {
            tvShortUrl.text = item.links.short
            tvOriginalUrl.text = item.links.self
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UrlViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_url, parent, false)
        return UrlViewHolder(view)
    }

    override fun onBindViewHolder(holder: UrlViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    fun updateList(newItems: List<UrlResponse>) {
        items = newItems
        notifyItemInserted(0)
    }
}