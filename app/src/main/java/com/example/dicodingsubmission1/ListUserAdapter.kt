package com.example.dicodingsubmission1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dicodingsubmission1.DetailActivity.Companion.EXTRA_DATA
import kotlinx.android.synthetic.main.item_list.view.*

class ListUserAdapter(private val list: ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = ListViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list, viewGroup, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val listUser = list[position]

        holder.bindItem(listUser)
        holder.itemView.setOnClickListener { view ->
            Toast.makeText(view.context, "You choose " + listUser.name, Toast.LENGTH_SHORT).show()

            val moveIntentWithObject = Intent(view.context, DetailActivity::class.java)
            moveIntentWithObject.putExtra(EXTRA_DATA, listUser)
            view.context.startActivity(moveIntentWithObject)
        }
    }

    inner class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(user: User) {
            with(itemView) {
                tv_item_name.text    = user.name
                tv_item_company.text = user.company
                Glide.with(itemView).load(user.avatar).into(img_item_avatar)
            }
        }
    }
}