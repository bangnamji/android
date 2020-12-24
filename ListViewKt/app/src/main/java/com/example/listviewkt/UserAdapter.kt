package com.example.listviewkt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

// listview는 Adapter와 꼭 연결해주어야 한다. 어려울 수 있어 ....
class UserAdapter(val context: Context, val UserList: ArrayList<User>) : BaseAdapter()
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        // Inflater는 뷰를 합쳐줄 때 사용
        val view: View =LayoutInflater.from(context).inflate(R.layout.list_item_user, null)
        //<> 안에는 형태를 적어줘야함함
        val profile = view.findViewById<ImageView>(R.id.iv_profile)
        val name = view.findViewById<TextView>(R.id.tv_name)
        val age = view.findViewById<TextView>(R.id.tv_age)
        val greet = view.findViewById<TextView>(R.id.tv_greet)

        // position은 배열처럼 0부터 ~
        val user = UserList[position]

        profile.setImageResource(user.profile)
        name.text = user.name
        age.text = user.age
        greet.text = user.greet

        // 꼭 return 해주기
        return view
    }

    override fun getItem(position: Int): Any {
        // 어떤 아이템을 끌고 올거니?
        return UserList[position]

    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return UserList.size
    }

}