package com.example.android7.Realm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android7.R
import io.realm.*
import kotlinx.android.synthetic.main.activity_realm__you_tube.*


// 사용할 데이터 클래스
open class Item : RealmObject() {
    open var name : String? = null
}

class RealmActivity_YouTube : AppCompatActivity() {
    var shoppingList = mutableListOf<Item>()    // 자바의 List<Item>과 동일한 기능
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm__you_tube)
        rc.adapter = RcAdapter()
        rc.layoutManager = LinearLayoutManager(this)

        // Realm이랑 연동시켜 보자자
       Realm.init(this)
        var config = RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build()    // delete~~는 skip 할 때마다 데이터 초기화

        var realm = Realm.getInstance(config)

        // button에 transaction 넣어보자
        button.setOnClickListener() {
            realm.beginTransaction()
            var item = realm.createObject(Item::class.java)
            item.name = editText.text.toString()
            realm.commitTransaction()
        }

        // 데이터가 바뀔때마다 이벤트가 발생하는 인터페이스 생성
        realm.where(Item::class.java).findAll().addChangeListener {     // addChangeListener는 데이터가 입력, 수정, 삭제 발생되는 부분
            t: RealmResults<Item>?, changeSet: OrderedCollectionChangeSet? ->
            shoppingList.clear()
            shoppingList.addAll(t!!)
            (rc.adapter as RcAdapter).notifyDataSetChanged()
        }

    }
    // RcylcerView의 Adapter
    // class에서 Alt+Enter 하면 implement들을 추가할 수 있다.
    inner class RcAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var textView = TextView(this@RealmActivity_YouTube)
            return CustomViewHolder(textView)
        }

        inner class CustomViewHolder(textView: TextView) : RecyclerView.ViewHolder(textView) {

        }

        override fun getItemCount(): Int {
            return shoppingList.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            var textView = holder!!.itemView as TextView    // holder에서 가지고 온다.
            textView.text = shoppingList[position].name
        }

    }
}