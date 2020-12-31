package com.example.flower

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row.view.*

class MyAdapter (val arrayList: ArrayList<Model>, val context: Context) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(model:Model) {

            itemView.titleTv.text = model.title
            itemView.descriptionTv.text = model.des
            itemView.imageIv.setImageResource(model.image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {

        return arrayList.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItems(arrayList[position])

        holder.itemView.setOnClickListener {

//            val model = arrayList.get(position)
//            var detail_Title : String = model.des
//            var gImageView : Int = model.image
//            var gDetail : String = model.detail


            if (position==0){
                Toast.makeText(context, "You clicked class 1", Toast.LENGTH_LONG).show()
                var intent = Intent(context, DetailOne::class.java)
                context.startActivity(intent)
            }
            if (position==1){
                Toast.makeText(context, "You clicked class 2", Toast.LENGTH_LONG).show()
                var intent = Intent(context, DetailTwo::class.java)
                context.startActivity(intent)
            }
            if (position==2){
                Toast.makeText(context, "You clicked class 3", Toast.LENGTH_LONG).show()
                var intent = Intent(context, ClassThree::class.java)
                context.startActivity(intent)
            }
            if (position==3){
                Toast.makeText(context, "You clicked class 4", Toast.LENGTH_LONG).show()
                var intent = Intent(context, ClassFour::class.java)
                context.startActivity(intent)
            }
            if (position==4){
                Toast.makeText(context, "You clicked class 5", Toast.LENGTH_LONG).show()
                var intent = Intent(context, ClassFive::class.java)
                context.startActivity(intent)
            }
            if (position==5){
                Toast.makeText(context, "You clicked class 6", Toast.LENGTH_LONG).show()
                var intent = Intent(context, ClassSix::class.java)
                context.startActivity(intent)
            }

//            intent.putExtra("iTitle", detail_Title)
//            intent.putExtra("iImagView", gImageView)
//            intent.putExtra("iDetail", gDetail)

//            context.startActivity(intent)
//            // Toast 기능 관련
//            if (position == 0){
//                Toast.makeText(context, "You clicked class 1", Toast.LENGTH_LONG).show()
//            }
//            if (position == 1){
//                Toast.makeText(context, "You clicked class 2", Toast.LENGTH_LONG).show()
//            }
//            if (position == 2){
//                Toast.makeText(context, "You clicked class 3", Toast.LENGTH_LONG).show()
//            }
//            if (position == 3){
//                Toast.makeText(context, "You clicked class 4", Toast.LENGTH_LONG).show()
//            }
//            if (position == 4){
//                Toast.makeText(context, "You clicked class 5", Toast.LENGTH_LONG).show()
//            }
//            if (position == 5){
//                Toast.makeText(context, "You clicked class 6", Toast.LENGTH_LONG).show()
//            }

        }

    }
}