package com.example.diaryinmyhand

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diaryinmyhand.databinding.ActivityDiaryWritingBinding
import java.text.SimpleDateFormat
import java.util.*

class DiaryWriting : AppCompatActivity() {

    var formatDate = SimpleDateFormat("YYYY년 MM월 dd일", Locale.KOREA)

    private lateinit var binding: ActivityDiaryWritingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiaryWritingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.textView.setOnClickListener {
            val getDate = Calendar.getInstance()
            val datepicker = DatePickerDialog(
                this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->
                    val selectDate = Calendar.getInstance()
                    selectDate.set(Calendar.YEAR, year)
                    selectDate.set(Calendar.MONTH, month)
                    selectDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    val date = formatDate.format(selectDate.time)
                    binding.textView.text = date
                },
                getDate.get(Calendar.YEAR),
                getDate.get(Calendar.MONTH),
                getDate.get(Calendar.DAY_OF_MONTH)
            )
            datepicker.show()
        }

        binding.Back.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

        binding.Ok.setOnClickListener {
            val intent1 = Intent(this,MainActivity2::class.java)
            startActivity(intent1)
        }

    }
}