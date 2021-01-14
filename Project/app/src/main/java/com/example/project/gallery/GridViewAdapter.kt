package com.example.project.gallery

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.project.R
import kotlinx.android.synthetic.main.gallary_grid_image.view.*



class GridViewAdapter():BaseAdapter()
{
    var images : List<ByteArray> = emptyList()
    var context:Context?=null

    constructor(context: Context, foodsList: List<ByteArray>) : this() {
        this.context = context
        this.images = foodsList
    }

    //화면에 어떻게 보일지지
   @SuppressLint("ServiceCast", "ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View
    {
        val img= BitmapFactory.decodeByteArray(images[position], 0, images[position].size)
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        var view = inflator.inflate(R.layout.gallary_grid_image, null)
        view.imageView.setImageBitmap(img)

        return view
    }

    override fun getItem(position: Int): Any {
        return images[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return images.size
    }

}