package com.example.flowerintro

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerAdapter: RecyclerView.Adapter<MyViewHolder>(){

    private var modelList = ArrayList<MyModel>()

    // 뷰홀더가 생성 되었을 때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        //연결할 레이아웃 설정
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_recycler_item, parent, false))
    }

    // 목록의 수
    override fun getItemCount(): Int {
        return this.modelList.size
    }

    // 뷰와 뷰홀더가 묶였을 때 -> 재활용이 되었을 때
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(this.modelList[position])

//        // 클릭 설정
//        holder.itemView.setOnClickListener{
//            Toast.makeText(App.instance, "${this.modelList[position].name} curriculm",Toast.LENGTH_SHORT).show()
//            val intent = Intent(holder.itemView?.context, DetailActivity::class.java)
//        }
    }
//
    fun submmitList(modelList: ArrayList<MyModel>){
        this.modelList = modelList
    }

}