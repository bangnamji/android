package com.example.android3;

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun numberEvent(view:View){
        if(isNewOp) {
            result.setText("")
        }
        isNewOp=false
        val buSelect = view as Button
        var buClickValue:String =result.text.toString()
        when(buSelect.id){
            num_1.id->{
                buClickValue+="1"
            }
            num_2.id->{
                buClickValue+="2"
            }
            num_3.id->{
                buClickValue+="3"
            }
            num_4.id->{
                buClickValue+="4"
            }
            num_5.id->{
                buClickValue+="5"
            }
            num_6.id->{
                buClickValue+="6"
            }
            num_7.id->{
                buClickValue+="7"
            }
            num_8.id->{
                buClickValue+="8"
            }
            num_9.id->{
                buClickValue+="9"
            }
            num_0.id->{
                buClickValue+="0"
            }
            dot.id->{
                //TODO: prevent adding more than 1 dot
                buClickValue+="."
            }
        }
        result.setText(buClickValue)
    }

var op="*"
var oldNumber=""
var isNewOp=true;
    fun buOpEvent(view: View){

        val buSelect= view as Button
        when(buSelect.id) {
            buMulti.id -> {
                op="*"
            }
            buDiv.id -> {
                op="/"
            }
            buSub.id -> {
                op="-"
            }
            buSum.id -> {
                op="+"
            }
        }
        oldNumber=result.text.toString()
        isNewOp=true
    }

    fun buEqualEvent(view: View){
        val newNumber=result.text.toString()
        var finalNumber:Double?=null
        when(op){
            "*"->{
                finalNumber=oldNumber.toDouble() *newNumber.toDouble()
            }
            "/"->{
                finalNumber=oldNumber.toDouble() /newNumber.toDouble()
            }
            "-"->{
                finalNumber=oldNumber.toDouble() -newNumber.toDouble()
            }
            "+"->{
                finalNumber=oldNumber.toDouble() +newNumber.toDouble()
            }
        }
        result.setText(finalNumber.toString())
        isNewOp=true
    }

    fun buPercent(view: View){
        val number:Double=result.text.toString().toDouble()/100

        result.setText(number.toString())
    }

    fun ClearEvent(view: View){
        result.setText("0")
        isNewOp=true
    }
}