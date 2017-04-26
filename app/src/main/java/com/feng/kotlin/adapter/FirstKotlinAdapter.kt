package com.feng.kotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

//定义数据适配器，通过“：”继承自RecyclerView.Adapter
class FirstKotlinAdapter(val items: List<String>) : RecyclerView.Adapter<FirstKotlinAdapter.ViewHolder>() {
    //创建ViewHodler
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    //绑定ViewHolder并设置数据
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]
    }

    //实现getItemCount，处理数据的条目数量
    override fun getItemCount(): Int = items.size;

    //定义ViewHolder，现在只需要一个	TextView
    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView);
}

