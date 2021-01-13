package com.example.galarypicker

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat.startActivityForResult
import android.content.Intent
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.app.Activity
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.BitmapFactory
import android.provider.MediaStore
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.net.Uri
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {


    lateinit var imageView: ImageView
    public override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = this.findViewById<View>(R.id.imageView) as ImageView


        button.setOnClickListener {

            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"

            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, 1)
            }
        }


        button1.setOnClickListener {

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED
            ) {
                // Permission is not granted

                permissionGrantAccess()
            }
            else
            {
                // Permission Granted Perform main Action

                val cameraIntent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(cameraIntent, 1888)
            }

        }
    }


    fun permissionGrantAccess()
    {

        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.CAMERA)) {


            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 1888)

        } else {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),1888)
        }
    }



        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            if (requestCode == 1888) {
                if (data != null) {
                    val photo = data?.extras!!.get("data") as Bitmap?

                    imageView.setImageBitmap(photo)
                } else {
                    Toast.makeText(this, "I got it ", Toast.LENGTH_LONG).show()
                }
            }

//            else if(requestCode==11)
//            {
//                val photo = data?.extras!!.get("data") as Bitmap?
//                imageView.setImageBitmap(photo)
//            }
        }


    }
