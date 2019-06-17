package com.tapdevs.mealsmodule.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tapdevs.base.network.model.meal.category.MealCategory
import com.tapdevs.mealsmodule.R
import kotlinx.android.synthetic.main.row_meal_category.view.*

class MealCategoriesAdapter : RecyclerView.Adapter<MealCategoriesAdapter.AlbumViewHolder>() {

    var albums: List<MealCategory> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.row_meal_category, parent, false))
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album: MealCategory = albums[position]
//        holder.albumID.text = album.id.toString()
//        holder.userID.text = album.userId.toString()
//        holder.title.text = album.title
    }

    fun setItems(albums: List<MealCategory>) {
        this.albums = albums
        notifyDataSetChanged()
    }
    inner class AlbumViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var albumID: TextView = view.albumID
        var userID: TextView = view.albumID
        var title: TextView = view.albumID
    }
}