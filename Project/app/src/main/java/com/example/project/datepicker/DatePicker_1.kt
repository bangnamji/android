package com.example.project.datepicker

import android.app.DatePickerDialog
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.project.CheckBoxActivity
import com.example.project.R
import com.example.project.databinding.ActivityDatePicker1Binding
import com.example.project.databinding.ActivityDatepickerBinding
import java.text.SimpleDateFormat
import java.util.*

class DatePicker_1 : AppCompatActivity() {

    var formatDate = SimpleDateFormat("YYYY년 MM월 dd일 ", Locale.KOREA)
    private lateinit var binding : ActivityDatePicker1Binding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatePicker1Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //날짜 설정할거야
        binding.tvDate.setOnClickListener {
            val getDate = Calendar.getInstance()
            val datepicker = DatePickerDialog(
                this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                    val selectDate = Calendar.getInstance()
                    selectDate.set(Calendar.YEAR, i)
                    selectDate.set(Calendar.MONTH, i2)
                    selectDate.set(Calendar.DAY_OF_MONTH, i3)
                    val date = formatDate.format(selectDate.time)
                    Toast.makeText(this, "Date : " + date, Toast.LENGTH_SHORT).show()
                    binding.tvDate.text = date

                },
                getDate.get(Calendar.YEAR),
                getDate.get(Calendar.MONTH),
                getDate.get(Calendar.DAY_OF_MONTH)
            )
            datepicker.show()

        }

        //데이터 저장하기 - SharedPreference
        val dmh_pref = this.getPreferences(0)       //0은 (Context.MODE_PRIVATE)과 동일하다
        val editor = dmh_pref.edit()

        binding.etDiary.setText(dmh_pref.getString("DIARY",""))


        //핸들러 사용해서 시간 지연 설정할거야 ~ toast랑 activity랑 겹치지 않게 !
        binding.autoSave.setOnClickListener {
            editor.putString("DIARY", binding.etDiary.text.toString()).apply()
            Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show()     //LENGHT_LONG은 몇 초 보일지 정하는거야~
            Handler().postDelayed({
                val intent = Intent(this, TestActivity::class.java)
                this.startActivity(intent)
            },2500)

            //Handler().postDelayed({ startActivity(Intent(StartActivity::class.java, MainActivity::class.java)) }, 2000L) 이렇게 써도 된다 ~

        }

    }


}