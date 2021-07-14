package com.saurabhbhola.centurion

import Persons
import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class RecyclerAdapter(val context: Context) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    var personsList : List<Persons> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_adapter,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return personsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tvMovieName.text = personsList.get(position).student_name
        Glide.with(context).load(personsList.get(position).student_photo)
            .apply(RequestOptions().centerCrop())
            .into(holder.image)
    }

    fun setPersonsListItems(personsList: List<Persons>){
        this.personsList = personsList;
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val tvMovieName: TextView = itemView!!.findViewById(R.id.title)
        val image: ImageView = itemView!!.findViewById(R.id.image)

    }
}