package com.example.android7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Practice3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice3)

        //On,Off기능
        //채널 돌리는 기능
        //초기 채널은(S사, M사, K사)
        val tv = TV(listOf<String>("K", "M", "S"))
        tv.switch()
        Log.d("TV", "" + tv.onOroff) //TV를 켜겠다.
        tv.channelUp()
        Log.d("TV", "" + tv.checkCurrentChannel())
        tv.channelUp()
        tv.channelUp()
        tv.channelUp()
        Log.d("TV", "" + tv.checkCurrentChannel())      //M
        tv.channelDown()
        Log.d("TV", "" + tv.checkCurrentChannel())
        tv.channelDown()
        tv.channelDown()
        tv.channelDown()
        Log.d("TV", "" + tv.checkCurrentChannel())      //K
    }
}

class TV(val channels: List<String>){
    var onOroff: Boolean = false    //True:On, False:Off
    var currentChannelNumber = 0    //TV를 틀었을 때 0을 가지도록 -> K가 기본

        set(value){
            //이 함수는 S채널 다음에 K채널로 오게하는 중요한 함수. field를 사용한다는 점 확인할 것.
            field = value

            if(field>2){
                field = 0
            }

            if(field<0){
                field = 2
            }
        }

        //set은 변수에 값이 '할당'될 때 사용한다.
        //get은 변수에 값이 '호출'될 때 사용한다.
        get(){
            println("TV가 호출되었습니다.")
            return field
        }

    fun switch(){
        onOroff = !onOroff
    }

    fun channelUp(){
        channels.forEachIndexed{index, value ->
            if (currentChannelNumber == index){
                currentChannelNumber +=1
                return
            }
        }
    }

    fun channelDown(){
        channels.forEachIndexed{index, value->
            if(currentChannelNumber==index){
                currentChannelNumber -= 1
                return
            }
        }
    }

    fun checkCurrentChannel(): String{
        return channels[currentChannelNumber]
    }
}