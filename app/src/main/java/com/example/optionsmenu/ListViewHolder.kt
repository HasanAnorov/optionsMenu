package com.example.optionsmenu

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class ListViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {

    val tvTitle :TextView=itemView.tvTitle
    val tvDescription:TextView=itemView.tvDescription

    fun populatemodel (
        user: User,
        activity: MainActivity

    ){

        tvTitle.text =user.title
        tvDescription.text=user.description

    itemView.setOnClickListener {
       activity.itemAdd(user)
}
itemView.btnoption.setOnClickListener {
    activity.onOptionsButtonClick(itemView.btnoption,position )
}


    }

}