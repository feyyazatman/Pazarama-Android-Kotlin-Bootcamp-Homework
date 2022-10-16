package com.feyyazatman.week3homework.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.feyyazatman.week3homework.data.ItemModel
import com.feyyazatman.week3homework.databinding.ItemDesignBinding


// parametre olarak onItemClicked adinda high-order func. tanimladim. Bu func. navigate ile veri tasima islemi yapicak.
class RecyclerViewAdapter(private val itemList: MutableList<ItemModel>, private val onItemClicked : (ItemModel) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val itemDesignBinding: ItemDesignBinding) : RecyclerView.ViewHolder(itemDesignBinding.root) {
        fun bind(item : ItemModel) {
            itemDesignBinding.apply {
                ivItem.setImageResource(item.ItemImage)
                tvItemName.text = item.ItemName
                tvItemPrice.text = item.ItemPrice
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemDesignBinding = ItemDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(itemDesignBinding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemView.setOnClickListener {
            onItemClicked(item)
        }
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}