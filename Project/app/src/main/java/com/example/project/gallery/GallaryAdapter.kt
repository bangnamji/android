package com.example.project.gallery

import android.content.ContentProvider
import android.content.ContentResolver
import android.content.Intent
import android.graphics.Bitmap
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.project.R
import kotlinx.android.synthetic.main.gallary_grid_image.view.*
import java.io.ByteArrayOutputStream

//class GallaryAdapter (val gallarylist: ArrayList<Gallary>) : RecyclerView.Adapter<GallaryAdapter.CustomViewHolder>() {
//
//    //액티비티의 oncreate와 유사하다 (xml 연결)
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GallaryAdapter.CustomViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.gallary_grid_image, parent, false)      //parent.context -> GallaryMainActivity와 연결된 모든 정보
//        return CustomViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return gallarylist.size
//    }
//
//    override fun onBindViewHolder(holder: GallaryAdapter.CustomViewHolder, position: Int) {
//        holder.images.setImageResource(gallarylist.get(position).images)
//
//    }
//
//
//    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val images = itemView.findViewById<ImageView>(R.id.imageView)
//    }
//
//}