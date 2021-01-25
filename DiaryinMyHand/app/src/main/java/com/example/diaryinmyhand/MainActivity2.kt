package com.example.diaryinmyhand

import android.content.DialogInterface
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.diaryinmyhand.databinding.ActivityMain2Binding
import com.example.diaryinmyhand.databinding.DiaryitemBinding
import java.lang.reflect.Type

class MainActivity2 : AppCompatActivity() {

    private val data = ArrayList<DiaryList>()

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

/*        //선택된 날짜 반영하기
        binding.calendarView.setOnDateChangeListener(object : CalendarView.OnDateChangeListener {
            override fun onSelectedDayChange(view: CalendarView, year: Int, month: Int, dayOfMonth: Int) {
                Toast.makeText(this@MainActivity2, "선택된 날짜는 $year.${month+1}.$dayOfMonth",
                Toast.LENGTH_SHORT). show()
            }
        })*/


        //recycler뷰로 해보자
        binding.list.apply {
            layoutManager = LinearLayoutManager(this@MainActivity2)

            adapter = DiaryAdapter(data, onClickMoreIcon = { moreDiary(it) })
        }

        binding.addButton.setOnClickListener {
            addDiary()
        }


        binding.Settings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        binding.Calendar.setOnClickListener {
            val intent1 = Intent(this, CalendarActivity::class.java)
            startActivity(intent1)
        }

        binding.Plus.setOnClickListener {
            addDiary()
            val intent2 = Intent(this, DiaryWriting::class.java)
            startActivity(intent2)
        }

    }

    private fun addDiary() {
        val diary = DiaryList(binding.diarymaintext.text.toString())
        data.add(diary)
        binding.list.adapter?.notifyDataSetChanged()
    }


    private fun moreDiary(diary: DiaryList) {
        val alertDialog = AlertDialog.Builder(this)
            .setTitle("목록")
            .setMessage("수행할 내용을 알려주시용!")
            .setPositiveButton("수정", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "일기를 수정합니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, DiaryWriting::class.java)
                startActivity(intent)
            })
            .setNegativeButton("삭제", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "일기를 삭제합니다.", Toast.LENGTH_SHORT).show()
                //일기 삭제하는 기능...
                data.remove(diary)
                binding.list.adapter?.notifyDataSetChanged()
            })
            .setNeutralButton("이모티콘", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "이모티콘을 설정합니다.", Toast.LENGTH_SHORT).show()
                //이모티콘 어쩌지.....
            })
            .create()
            .show()
        //binding.list.adapter?.notifyDataSetChanged()
    }
}

data class DiaryList(val text:String)

class DiaryAdapter(private val myDiary: ArrayList<DiaryList>, val onClickMoreIcon: (diary:DiaryList)->Unit):RecyclerView.Adapter<DiaryAdapter.DiaryViewHolder>() {

    inner class DiaryViewHolder(val binding: DiaryitemBinding) : RecyclerView.ViewHolder(binding.root) {
        //val nameTv = itemView?.findViewById<TextView>(R.id.item_title)

/*        fun bind(data:Data){
            nameTv?.text=data.dataTitle
        }*/

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiaryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.diaryitem, parent, false)
        return DiaryViewHolder(DiaryitemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: DiaryViewHolder, position: Int) {
        val diary = myDiary[position]


        holder.binding.itemTitle.text = diary.text

        holder.binding.more.setOnClickListener {
            onClickMoreIcon.invoke(diary)
        }



        holder.binding.itemTitle.setOnClickListener {
            val intent = Intent(holder.itemView?.context, DiaryWriting::class.java)
            holder.itemView?.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return myDiary.size
    }


}