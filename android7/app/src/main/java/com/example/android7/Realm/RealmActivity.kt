package com.example.android7.Realm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.android7.R
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmObject
import kotlinx.android.synthetic.main.activity_realm.*

class RealmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        Realm.init(this@RealmActivity)
        Realm.init(this@RealmActivity)
        val config: RealmConfiguration =RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded() //이거는 Migration이 필요해지는 상황이 오면 realm을 지워버리겠다.
                .build()
        //이렇게 .을 찍는 것을 Method Chaining이라고 한다.
        //Migration은 DB를 동기화 해주겠다는 의미
        //테이블에 추가내용을 적고 싶을때 (전화번호 추가등) 둘의 DB를 합쳐야되는데 이걸 Migration이라고 한다.

        Realm.setDefaultConfiguration(config)
        val realm = Realm.getDefaultInstance()

        // 데이터 저장
        btn_save.setOnClickListener {
            realm.executeTransaction{
                //A테이블에서 데이터를 가져온다.
                //B테이블에서 데이터를 가져온다.
                //C테이블에서 데이터를 가져온다.
                //조합을 한다.
                //D테이블에 저장을 한다.
                //commit할때 배운 beginTransaction와 commit을 하나로 합친것이라고 이해해두자
                with(it.createObject(School::class.java)){
                    this.name="어떤 대학교"
                    this.location="서울"
                }


            }
        }

        // 데이터 불러오기
        btn_load.setOnClickListener {
            realm.executeTransaction{
                val data= it.where(School::class.java).findFirst()
                Log.d("data","data: " +data)
            }

        }

        btn_delete.setOnClickListener {
            realm.executeTransaction{
                it.where(School::class.java).findAll().deleteAllFromRealm() //전부다 지움
                //it.where(School::class.java).findFirst().deleteFromRealm()//첫번째꺼 하나만 지움
            }

        }

    }
}

open class School: RealmObject() {
    var name:String?=null
    var location:String?=null
}