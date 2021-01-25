package com.example.diaryinmyhand

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.diaryinmyhand.databinding.ActivityDiaryWritingBinding
import java.text.SimpleDateFormat
import java.util.*

class DiaryWriting : AppCompatActivity() {

    private var Datadb:DataDB?=null
    private val OPEN_GALLERY=1

    var formatDate = SimpleDateFormat("YYYY년 MM월 dd일", Locale.KOREA)

    private lateinit var binding : ActivityDiaryWritingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiaryWritingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Datadb = DataDB.getInstance(this)

        val addRunnable = Runnable {
            val newCat = Data()

            newCat.dataTitle = binding.titleWrite.text.toString()
            newCat.dataImage = binding.imageContent.imageAlpha
            newCat.dataContent = binding.contentWrite.text.toString()
            Datadb?.dataDao()?.insert(newCat)
        }

        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR).toString()
        val month = (cal.get(Calendar.MONTH)+1).toString()
        val day = cal.get(Calendar.DATE).toString()

        val currentdate = formatDate.format(cal.time)
        binding.textView.text = currentdate

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
            val addThread = Thread(addRunnable)
            addThread.start()

            val i = Intent(this, MainActivity2::class.java)
            startActivity(i)
            finish()

            /*val intent1 = Intent(this,MainActivity2::class.java)
            startActivity(intent1)*/
        }

        binding.Picture.setOnClickListener {
            openGallery()
        }
    }

    private fun openGallery() {
        val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.setType("image/*")
        startActivityForResult(intent, OPEN_GALLERY)
    }

    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == OPEN_GALLERY) {
                var currentImageUrl: Uri? = data?.data

                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, currentImageUrl)
                    binding.imageContent.setImageBitmap(bitmap)

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        else {
            Log.d("ActivityResult", "something wrong")
        }
    }

    override fun onDestroy() {
        DataDB.destroyInstance()
        super.onDestroy()
    }

}
