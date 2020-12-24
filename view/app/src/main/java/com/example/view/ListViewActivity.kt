package com.example.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.view.databinding.ActivityListViewBinding
import android.widget.Toast

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val CarList = ArrayList<CarForList>()
        for(i in 0 until 10){
            CarList.add(CarForList(""+i+"번째 자동차",""+i+"순위 엔진"))
        }
        val adpater=ListViewAdapter(CarList, LayoutInflater.from(this@ListViewActivity))
        binding.listView.adapter=adpater
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val carName =(adpater.getItem(position) as CarForList).name
            var carEngine = (adpater.getItem(position)as CarForList).engine
            Toast.makeText(this@ListViewActivity,carName+""+carEngine,Toast.LENGTH_SHORT).show()
        }
    }
}

class ListViewAdapter(
    val carForList: ArrayList<CarForList>,
    val layoutInflater: LayoutInflater
): BaseAdapter(){
    override fun getCount(): Int {
        return carForList.size
    }

    override fun getItem(position: Int): Any {
        return carForList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder : ViewHolder
        if(convertView == null){
            view=layoutInflater.inflate(R.layout.car_view,null)
            holder = ViewHolder()
            holder.carName=view.findViewById(R.id.car_name)
            holder.carEngine=view.findViewById(R.id.car_engine)
            view.tag=holder
        }
        else{
            holder=convertView.tag as ViewHolder
            view=convertView
        }
        holder.carName?.text= carForList[position].name
        holder.carEngine?.text= carForList[position].engine
        return view
    }
}

class ViewHolder{
    var carName: TextView?=null
    var carEngine:TextView?=null
}