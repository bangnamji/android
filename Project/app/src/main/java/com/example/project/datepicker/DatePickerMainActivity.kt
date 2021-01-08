package com.example.project.datepicker

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.widget.Toast
import com.example.project.R
import com.example.project.databinding.ActivityDatepickerBinding
import java.text.SimpleDateFormat
import java.util.*

class DatePickerMainActivity : AppCompatActivity() {

    var formatDate = SimpleDateFormat("YYYY년 MM월 dd일 ", Locale.KOREA)

    private lateinit var binding : ActivityDatepickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatepickerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnPickDate.setOnClickListener {
            val getDate = Calendar.getInstance()
            val datepicker = DatePickerDialog(this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                    val selectDate = Calendar.getInstance()
                    selectDate.set(Calendar.YEAR,i)
                    selectDate.set(Calendar.MONTH, i2)
                    selectDate.set(Calendar.DAY_OF_MONTH, i3)
                    val date = formatDate.format(selectDate.time)
                    Toast.makeText(this,"Date : "+date,Toast.LENGTH_SHORT).show()
                    binding.tvGetDate.text = date

                },
                getDate.get(Calendar.YEAR), getDate.get(Calendar.MONTH), getDate.get(Calendar.DAY_OF_MONTH))
            datepicker.show()

        }
    }
}