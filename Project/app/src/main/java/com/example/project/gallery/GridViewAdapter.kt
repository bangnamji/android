package com.example.project.gallery

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.project.R
import kotlinx.android.synthetic.main.gallary_grid_image.*
import kotlinx.android.synthetic.main.gallary_grid_image.view.*
import java.io.IOException

class GridViewAdapter(): BaseAdapter()
{
    var images : List<ByteArray> = emptyList()
    var context: Context?=null


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
    private fun rotate(bitmap: Bitmap, degree: Int) : Bitmap {
        val matrix = Matrix()
        matrix.postRotate(degree.toFloat())
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
    }

    constructor(context: Context, foodsList: List<ByteArray>) : this() {
        this.context = context
        this.images = foodsList
    }
    @SuppressLint("ServiceCast", "ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View
    {
        val img= BitmapFactory.decodeByteArray(images[position], 0, images[position].size)
        lateinit var exif: ExifInterface

        try {
            exif = ExifInterface(images[position])
            var exifOrientation = 0
            var exifDegree = 0

            if( exif!= null){
                exifOrientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)
                exifDegree = exifOrientationToDegree(exifOrientation)
            }
            imageView.setImageBitmap(rotate(bitmap, exifDegree))
        }catch (e : IOException){
            e.printStackTrace()
        }
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        var view = inflator.inflate(R.layout.gallary_grid_image, null)
        view.imageView.setImageBitmap(img)

        return view
    }

    override fun getItem(position: Int): Any {
        return images[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return images.size
    }

}