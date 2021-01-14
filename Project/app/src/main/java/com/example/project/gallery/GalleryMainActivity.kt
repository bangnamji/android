package com.example.project.gallery
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Matrix
import android.media.ExifInterface
import android.os.Bundle
import android.preference.PreferenceManager
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.project.databinding.ActivityGalleryMainBinding
import kotlinx.android.synthetic.main.gallary_grid_image.*
import java.io.ByteArrayOutputStream
import java.util.jar.Manifest
import kotlin.collections.ArrayList

@Suppress("DEPRECATION")
class GalleryMainActivity : AppCompatActivity() {


    private val CAMERA_PERMISSION = arrayOf(android.Manifest.permission.CAMERA)
    private val STORAGE_PERMISSION = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
    //어떤 액티비인지 식별하는 값
    val REQUESTCODE_CAMERA = 1
    val REQUESTCODE_GALLERY = 2

    val PERMISSION_CAMERA = 3
    val PERMISSION_STORAGE = 4
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
//            takePhotoFromCamera()
            openCamera()

        }

        binding.Gallery.setOnClickListener {
            selectImageFromGallery()
        }

        binding.clearAll.setOnClickListener {

            //이미지를 모두 삭제
            imageArray.clear()
            //어댑터를 null로 설정
            binding.gvGallery.adapter=null
        }
    }



    private fun checkPermission(permissions: Array<out String>, flag : Int) : Boolean {
        for(permission in permissions) {
            if(ContextCompat.checkSelfPermission(this,permission) !=
                    PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, permissions, flag)
                return false
            }
        }
        return true
    }

    private fun openCamera() {
        if(checkPermission(CAMERA_PERMISSION, PERMISSION_CAMERA)) {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent,REQUESTCODE_CAMERA)
        }
    }

    private fun selectImageFromGallery() {
        var intent = Intent()
        intent.type = "image/*"     //안드로이드 파일 탐색기 type별 intent 호출 (갤러리 호출은 image/*),
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)      //여러 파일을 선택할 수 있도록
        intent.action = Intent.ACTION_OPEN_DOCUMENT

        //시작한 액티비티를 통해 어떠한 결과값을 받기 위해 사용
        //새 액티비티를 열어줌 + 결과값 전달
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUESTCODE_GALLERY)
    }

    private fun takePhotoFromCamera() {

//        카메라 앱으로 사진 촬영 요청
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
//            Log.d("~~~~TAG","Inside Camera")
//

            val bitmap = intent?.extras!!.get("data") as Bitmap
            imageView.setImageBitmap(bitmap)

//            val imageBitmap = intent?.extras!!.get("data") as Bitmap
            val bytes = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes)
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

//                lateinit var exif: ExifInterface
//
//                try {
//                    exif = ExifInterface()
//                    var exifOrientation = 0
//                    var exifDegree = 0
//
//                    if( exif!= null){
//                        exifOrientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)
//                        exifDegree = exifOrientationToDegree(exifOrientation)
//                    }
//                    imageView.setImageBitmap(rotate(bitmap, exifDegree))
//                }catch (e : IOException){
//                    e.printStackTrace()
//                }

                val bytes = ByteArrayOutputStream()

                imageBitmap?.compress(Bitmap.CompressFormat.JPEG, 90, bytes)
                imageArray.add(bytes.toByteArray())
                bytes.close()
            }

        }

        adapter = GridViewAdapter(this, imageArray)
        binding.gvGallery.adapter = adapter

    }


    //마음대로 돌아가는 사진 제대로 회전시키자 ~
    private fun exifOrientationToDegree(exifOrientation: Int): Int {
        when(exifOrientation) {
            ExifInterface.ORIENTATION_ROTATE_90 -> return 90
            ExifInterface.ORIENTATION_ROTATE_180 -> return 180
            ExifInterface.ORIENTATION_ROTATE_270 -> return 270

            else -> return 0    //사진이 찍힌 그 상태로 유지
        }
    }

    //실제 회전이 돌아가는 코드
    //degree는 exifOrientationToDegree() 함수에서 리턴된 값
    //근데 해결못했어 ~~ ㅋ ㅋ ㅋ ㅋ ㅋ
    private fun rotate(bitmap: Bitmap, degree: Int) : Bitmap {
        val matrix = Matrix()
        matrix.postRotate(degree.toFloat())
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
    }


}




