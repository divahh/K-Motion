package com.example.myrecyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListVideoAdapter(private val listVideo: ArrayList<Video>) : RecyclerView.Adapter<ListVideoAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_video, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo, album, releaseYear, agency) = listVideo[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = if (description.length > 100) {
            description.take(100) + "..."
        } else {
            description
        }

        holder.itemView.setOnClickListener{
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("VIDEO_NAME", name)
            intent.putExtra("VIDEO_DESCRIPTION", description)
            intent.putExtra("VIDEO_PHOTO", photo)
            intent.putExtra("VIDEO_ALBUM", album)
            intent.putExtra("VIDEO_RELEASE_YEAR", releaseYear)
            intent.putExtra("VIDEO_AGENCY", agency)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listVideo.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}