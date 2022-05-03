package com.mahmoudbashir.daggerhiltexample.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mahmoudbashir.daggerhiltexample.R
import com.mahmoudbashir.daggerhiltexample.data.model.User
import com.squareup.picasso.Picasso

class MainAdapter (
    private val users: ArrayList<User>
        ): RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        var userName = itemView.findViewById<TextView>(R.id.textViewUserName)
        var userEmail = itemView.findViewById<TextView>(R.id.textViewUserEmail)
        var userImage = itemView.findViewById<ImageView>(R.id.imageViewAvatar)
        fun bind(user: User) {
            userName.text = user.name
            userEmail.text = user.email
            Picasso.get().load(user.avatar).placeholder(R.drawable.ic_launcher_background).into(userImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder=
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.single_item_layout,parent,false)
        )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
       holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size

    fun updateDataList(mlist:List<User>){
        users.addAll(mlist)
        notifyDataSetChanged()
    }
}