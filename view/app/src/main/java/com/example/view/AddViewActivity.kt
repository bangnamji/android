package com.example.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.view.databinding.ActivityAddViewBinding
import android.widget.TextView

class AddViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityAddViewBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // 아이템 리스트 준비비
       val CarList = ArrayList<CarForList>()
        for(i in 0 until 10){
            CarList.add(CarForList("" + i +"번째 자동차",""+i+"순위 엔진"))
        }

        // 10개를 컨테이너에 addView로 더한다.
        val container = binding.addviewContainer
        val inflater= LayoutInflater.from(this@AddViewActivity)
        for (i in 0 until CarList.size) {
            val itemView = inflater.inflate(R.layout.car_view, null)
            val carNameView = itemView.findViewById<TextView>(R.id.car_name)
            val carEngineView = itemView.findViewById<TextView>(R.id.car_engine)
            carNameView.text = CarList.get(i).name
            carEngineView.text = CarList.get(i).engine
            container.addView(itemView)
        }
    }
}

class CarForList(val name:String,val engine:String){

}
