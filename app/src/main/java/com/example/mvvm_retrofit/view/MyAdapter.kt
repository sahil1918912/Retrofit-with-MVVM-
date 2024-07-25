package com.example.mvvm_retrofit.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm_retrofit.R
import com.example.mvvm_retrofit.model.UserItem

class MyAdapter(private val context: Context, private val list: List<UserItem>) : RecyclerView.Adapter<MyAdapter.ViewHolder> () {

    inner class ViewHolder(v : View) : RecyclerView.ViewHolder(v) {

        var img = v.findViewById<ImageView>(R.id.userImg)
        var name = v.findViewById<TextView>(R.id.userName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_items,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.count()


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(list[position].avatar_url).into(holder.img)
        holder.name.text = list[position].login
    }
}