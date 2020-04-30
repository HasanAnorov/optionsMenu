package com.example.optionsmenu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class ListAdapter (val activity: MainActivity):RecyclerView.Adapter<ListViewHolder>(){


     var models : ArrayList<User> = arrayListOf()


    fun setData(data:ArrayList<User>){

    models=data

    notifyDataSetChanged()

    }

    fun removeItem(position: Int){


        models.removeAt(position)
        notifyItemRemoved(position)

    }






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        val itemView: View =LayoutInflater.from(parent.context).inflate(R.layout.item,parent, false)
        return ListViewHolder(itemView)

    }

    override fun getItemCount(): Int {
      return  models.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        holder.populatemodel(models[position], activity)

    }


}