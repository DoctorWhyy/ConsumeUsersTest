package com.my.consumeuserstest.presentation.userlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.my.consumeuserstest.R
import com.my.consumeuserstest.domain.model.UserList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.user_item.view.*

class UserListAdapter(val onItemClick: (UserList) -> Unit) :
    RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    val usersList = mutableListOf<UserList>()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val mUserData = usersList[position]
        mUserData.let { holder.bind(it) }
    }

    override fun getItemCount() = usersList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewContainer = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item, parent, false)
        val viewHolder = ViewHolder(viewContainer)
        viewContainer.setOnClickListener { onItemClick(usersList[viewHolder.adapterPosition]) }
        return viewHolder
    }

    fun updateUsers(users: List<UserList>) {
        this.usersList.clear()
        this.usersList.addAll(users)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(usersList: UserList) {

            itemView.tv_email.text = usersList.email
            itemView.tv_full_name.text = fullNameText(usersList.firstName, usersList.lastName)

            usersList.avatarUrl?.let {
                if (it.isNotEmpty()) {
                    Picasso.with(itemView.iv_avatar.context)
                        .load(usersList.avatarUrl)
                        .placeholder(R.drawable.ic_launcher_background)
                        .fit()
                        .centerCrop()
                        .into(itemView.iv_avatar)
                }
            }
        }

        private fun fullNameText(firstName: String, lastName: String): String =
            "$firstName $lastName"
    }
}