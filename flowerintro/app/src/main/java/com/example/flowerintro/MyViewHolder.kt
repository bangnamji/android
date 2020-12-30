package com.example.flowerintro

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_recycler_item.view.*
import java.text.FieldPosition


// RecyclerView를 상속받도록 되어 있음
class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val Tag: String = "로그"


    init{
        itemView.setOnClickListener{

        }
    }
    private val usernameTextView = itemView.user_name_text
    private val profileImageView = itemView.profile_img

//    fun initialize(modelList:MyModel, action: OnFlowerItemClickListener) {
//
//    }

    // 기본 생성자
    // 뷰랑 데이터랑 묶어줘야한다.
    fun bind(myModel: MyModel){
        usernameTextView.text = myModel.name

        Glide
            .with(App.instance)
            .load(myModel.profileImage)
            .into(profileImageView)
    }

//    // !! 추가
//    interface OnFlowerItemClickListener{
//        fun onItemClick(modelList: DetailActivity, position: Int)
//    }
}







