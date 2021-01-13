package com.example.project.gallery

import android.content.Context
import android.content.Intent
import android.graphics.*
import android.media.ExifInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.Modify
import com.example.project.R
import com.example.project.TodoCheckAdapter
import com.example.project.TodoCheckList
import com.example.project.databinding.ActivityGalleryMainBinding
import com.example.project.databinding.TodolistCheckboxBinding
import kotlinx.android.synthetic.main.gallary_grid_image.*
import kotlinx.android.synthetic.main.gallary_grid_image.view.*
import java.io.ByteArrayOutputStream
import java.io.IOException

class GalleryMainActivity : AppCompatActivity() {

    //어떤 액티비인지 식별하는 값
    val REQUESTCODE_CAMERA = 1
    val REQUESTCODE_GALLERY = 2
    var imageArray = ArrayList<ByteArray>()
    private var adapter: GridViewAdapter? = null

    private lateinit var binding: ActivityGalleryMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //각 버튼이 할 기능 설정
        binding.Camera.setOnClickListener {
            takePhotoFromCamera()
        }

        binding.Gallery.setOnClickListener {
            selectImageFromGallary()
        }

        binding.clearAll.setOnClickListener {

            //이미지를 모두 삭제
            imageArray.clear()
            //어댑터를 null로 설정
            binding.GridView.adapter=null
        }
    }


    private fun selectImageFromGallary() {
        var intent = Intent()
        intent.type = "image/*"     //안드로이드 파일 탐색기 type별 intent 호출 (갤러리 호출은 image/*),
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)      //여러 파일을 선택할 수 있도록
        intent.action = Intent.ACTION_OPEN_DOCUMENT

        //시작한 액티비티를 통해 어떠한 결과값을 받기 위해 사용
        //새 액티비티를 열어줌 + 결과값 전달
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUESTCODE_GALLERY)
    }

    private fun takePhotoFromCamera() {
        //카메라 앱으로 사진 촬영 요청
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUESTCODE_CAMERA)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, intent)

        //for intent with request code for camera
        if (requestCode == REQUESTCODE_CAMERA)
        {
            //To check on Logcat terminal if inside camera section
            Log.d("~~~~TAG","Inside Camera")


            val imageBitmap = intent?.extras!!.get("data") as Bitmap
            val bytes = ByteArrayOutputStream()
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes)
            imageArray.add(bytes.toByteArray())
            bytes.close()
        }
        //갤러리에서 사진 가져오자 ~
        else if (requestCode == REQUESTCODE_GALLERY)
        {
            //To check on Logcat terminal if inside gallery section
            Log.d("~~~~TAG","Inside Gallery")

            if(intent?.data!=null)
            {
                val imageBitmap = intent?.data?.let { MediaStore.Images.Media.getBitmap(this.contentResolver, it)
                }

                val bytes = ByteArrayOutputStream()

                imageBitmap?.compress(Bitmap.CompressFormat.JPEG, 90, bytes)
                imageArray.add(bytes.toByteArray())
                bytes.close()
            }

        }

        adapter = GridViewAdapter(this, imageArray)
        binding.GridView.adapter = adapter

    }



}


