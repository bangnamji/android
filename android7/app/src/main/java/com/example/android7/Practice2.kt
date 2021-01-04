package com.example.android7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


class Practice2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice2)

        val account:Acccount=Acccount("방남지","1997/03/04",10000)


        Log.d("잔액확인",""+account.CheckBalance())
        Log.d("1000원 저축하기",""+account.MoneyIn(1000))
        Log.d("5000원 찾기",""+account.MoneyOut(5000))
        Log.d("잔액 다시 확인하기",""+account.CheckBalance())
    }
}



class Acccount {

    var name: String
    var birth: String
    var balance: Int

    //계좌 생성 기능
    constructor(AccountName: String, AccountBirth: String, AccountBalance: Int) {
        this.name = AccountName
        this.birth = AccountBirth

        if (AccountBalance >= 0) {      //초기금액이 음수인 경우를 막기 위해서 if문 설정
            this.balance = AccountBalance
        } else {
            this.balance = 0
        }
    }

        //잔고 확인하기
        fun CheckBalance(): Int {
            return balance
        }

        //예금 기능
        fun MoneyIn(amount: Int):Int {
            balance += amount
            return balance
        }

        //출금 기능
        fun MoneyOut(amount: Int): Boolean {
            if (balance >= amount) {
                balance -= amount
                return true
            }
            else {
                return false
            }
        }
}
