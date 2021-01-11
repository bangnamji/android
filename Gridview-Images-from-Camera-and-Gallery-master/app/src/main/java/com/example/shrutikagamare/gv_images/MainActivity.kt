package com.example.shrutikagamare.gv_images

import android.annotation.TargetApi
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.support.annotation.RequiresApi
import android.util.Base64
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.ByteArrayOutputStream
import android.media.ExifInterface




class MainActivity : AppCompatActivity() {
    val REQUESTCODE_CAMERA = 1
    val REQUESTCODE_GALLERY = 2
    var imageArray=ArrayList<ByteArray>()
    private var adapter: GridViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //image from camera
        Camera.setOnClickListener {
            takePhotoFromCamera()
        }

        //image from gallery
        Gallery.setOnClickListener {
            selectImageFromGallery()
        }

        //clears all the images from Gridview
        clearAll.setOnClickListener {

            //clears contents from ArrayList
            imageArray.clear()

            //sets adapter to null
            GridView.adapter=null
        }

    }


    private fun selectImageFromGallery()
    {
        var intent = Intent()
        intent.type = "image/*"
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        intent.action = Intent.ACTION_OPEN_DOCUMENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUESTCODE_GALLERY)
    }

    private fun takePhotoFromCamera()
    {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUESTCODE_CAMERA)
            }
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?)
    {
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
        //for intent with request code for gallery
        else if (requestCode == REQUESTCODE_GALLERY)
        {
            //To check on Logcat terminal if inside gallery section
            Log.d("~~~~TAG","Inside Gallery")

            if(intent?.data!=null)
            {
                val imageBitmap = intent?.data?.let { MediaStore.Images.Media.getBitmap(this.contentResolver, it) }

                val bytes = ByteArrayOutputStream()

                imageBitmap?.compress(Bitmap.CompressFormat.JPEG, 90, bytes)
                imageArray.add(bytes.toByteArray())
                bytes.close()
            }
        }

        adapter = GridViewAdapter(this, imageArray)
        GridView.adapter = adapter

    }


}
