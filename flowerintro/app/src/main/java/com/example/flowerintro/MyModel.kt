package com.example.flowerintro

import android.os.Bundle
import android.util.Log

class MyModel(var name: String? = null, var profileImage: String? = null) {
    val Tag: String = "로그"

    // 기본 생성자
    init {
        Log.d(Tag, "MyModel = init() called")
    }

}