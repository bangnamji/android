package com.example.diaryinmyhand

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
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


/*        //addview로 해보기
        var linearLayout: LinearLayout = findViewById(R.id.list)
        for (i in 1 .. 10) {
            val view: View = layoutInflater.inflate(R.layout.diaryitem,null)
            val tvItem: TextView = view.findViewById(R.id.item_title)
            tvItem.setText(""+ i +"번째 다이어리")
            linearLayout.addView(view)
        }*/

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
        data.remove(diary)
        binding.list.adapter?.notifyDataSetChanged()
    }
}

data class DiaryList(val text:String)

class DiaryAdapter(private val myDiary: ArrayList<DiaryList>, val onClickMoreIcon: (diary:DiaryList)->Unit):RecyclerView.Adapter<DiaryAdapter.DiaryViewHolder>() {

    inner class DiaryViewHolder(val binding: DiaryitemBinding) : RecyclerView.ViewHolder(binding.root)

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

    }

    override fun getItemCount(): Int {
        return myDiary.size
    }


}