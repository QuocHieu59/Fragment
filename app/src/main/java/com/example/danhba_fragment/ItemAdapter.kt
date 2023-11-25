package com.example.danhba_fragment

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ItemAdapter(val items: ArrayList<ItemModel>): BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var itemView: View
        var itemViewHolder: ItemViewHolder

        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.layout_item, parent, false)

            itemViewHolder = ItemViewHolder(itemView)
            itemView.tag = itemViewHolder
        } else {
            itemView = convertView
            itemViewHolder = itemView.tag as ItemViewHolder
        }

        itemViewHolder.textName.text = items[position].name

        itemViewHolder.imageThumb.setImageResource(items[position].imageThumb)


        return itemView
    }

    class ItemViewHolder(itemView: View) {
        val imageThumb: ImageView
        val textName: TextView
        init {
            imageThumb = itemView.findViewById(R.id.image_thumb)
            textName = itemView.findViewById(R.id.text_name)

            Log.v("TAG", "findViewById")
        }
    }
}