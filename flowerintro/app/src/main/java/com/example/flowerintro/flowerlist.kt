package com.example.flowerintro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_flowerlist.*

class flowerlist : AppCompatActivity() {  // !!OnClick~ 추가했다

//    val TAG: String = "로그"

    // 데이터를 담을 그릇 즉 배열
    var modelList = ArrayList<MyModel>()

    private lateinit var myRecyclerAdapter: MyRecyclerAdapter


    // 뷰가 화면에 그려질 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flowerlist)


        // 10번 반복한다
            for (i in 1..6) {
                var myModel = MyModel(
                    name = "class $i",
                    profileImage = "https://img1.daumcdn.net/thumb/R1280x0.fjpg/?fname=http://t1.daumcdn.net/brunch/service/user/3iI8/image/XiCFi_VS6qwk40IxdGBtYCsbFBU.jpg"
                )
                this.modelList.add(myModel)
            }

        // 어답터 인스턴스 생성
        myRecyclerAdapter = MyRecyclerAdapter()

        myRecyclerAdapter.submmitList(this.modelList)

        // 리사이클러뷰 설정
        my_recylcer_view.apply {
            layoutManager = LinearLayoutManager(this@flowerlist, LinearLayoutManager.VERTICAL, false)   // false는 reverse를 안한다.

            // 어답터 장착
            adapter = myRecyclerAdapter
        }
    }

//    override fun onItemClick(modelList: DetailActivity, position: Int) {
//
//    }
}