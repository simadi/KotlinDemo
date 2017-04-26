package com.feng.kotlin.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView

import com.squareup.picasso.Picasso
import com.feng.kotlin.R
import org.jetbrains.anko.async


class ImageListAdapter0(context: Context,val imageUrls: Array<String>) : ArrayAdapter<String>(context,R.layout.item_picasso,imageUrls) {

    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
        var convertView1 = convertView
        if (convertView1 == null) {
            convertView1 = View.inflate(context, R.layout.item_picasso, null)
        }
          //加载图片
        Picasso.with(context).load(imageUrls[position]).into(convertView1 as ImageView?)
        return convertView1
    }
}