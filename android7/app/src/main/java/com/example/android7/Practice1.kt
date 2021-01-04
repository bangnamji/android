package com.example.android7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Practice1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice1)

        val operator:Operator= Operator()       // operator가 Operator이라는 자료형을 가진다. Operator의 클래스를 보자.
        Log.d("더하기","" + operator.plus(4,5))
        Log.d("빼기","" + operator.minus(4,5))
        Log.d("곱하기","" + operator.multi(4,5))
        Log.d("나누기","" + operator.divi(4,5))

        val operator2:Operator2= Operator2()
        Log.d("더하기","" + operator2.plus(1,2,3,4,5))
        Log.d("빼기","" + operator2.minus(10,2,3,4))
        Log.d("곱하기","" + operator2.multi(1,2,3,4))
        Log.d("나누기","" + operator2.divide(10,2,3))


        val operator3:Operator3= Operator3(3)
        Log.d("더하고 빼기","" + operator3.plus(5).minus(3))
        //Operator3(3).plus(5)------>Operator3(8).minus(3)
    }
}

// 비교해보자.
class Operator() {
    fun plus(a: Int, b: Int): Int {
        return a + b
    }
    fun minus(a: Int, b: Int): Int {
        return a - b
    }
    fun multi(a: Int, b: Int): Int {
        return a * b
    }
    fun divi(a: Int, b: Int): Int {
        return a / b
    }
}

// 숫자가 5개 들어간다.
class Operator2(){
    fun plus(vararg number:Int):Int{       // vararg는 매개변수(int형). Int{}는 return
        var result = 0
        number.forEach {        // forEach 반복문 -> 5개의 숫자에 대해서 (1,2,3,4,5)
            result = result+it      // it -> 1,2,3,4,5
        }
        return result
    }
    fun minus(vararg number:Int):Int{
        var result:Int = number[0]
        for(i in 0 until number.size) {     // number.size : 5
            if(i!=0){
                result -= number[i]
            }
        }
        return result
    }

    fun multi(vararg number:Int):Int{
        var result:Int = 1 //0으로 두면 안 된다.
        number.forEach {
            result = result*it
        }
        return result
    }

    fun divide(vararg number: Int): Int {
        var result: Int = number[0] //0으로 두면 안 된다.
        number.forEachIndexed { index, value ->
            if (index != 0 && value != 0) {
                result /= value
            }
        }
        return result
    }
}


//체이닝 방법 Operator3
//각 멤버함수의 반환값이 Operator3라는 것은 뒤에 이어서 다른 멤버함수를 붙여서 사용하고 싶다는 의미

class Operator3(val initialValue:Int){      // initialValue==3
    fun plus(number:Int):Operator3{
        val result = this.initialValue+number       // 3+5
        return Operator3(result)
    }
    fun minus(number:Int):Operator3{
        val result = this.initialValue-number   // 8-3
        return Operator3(result)
    }
    fun multi(number:Int):Operator3{
        val result = this.initialValue*number
        return Operator3(result)
    }
    fun divide(number:Int):Operator3{
        val result = this.initialValue/number
        return Operator3(result)
    }
}