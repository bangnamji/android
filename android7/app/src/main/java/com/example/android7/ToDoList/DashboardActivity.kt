package com.example.android7.ToDoList

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android7.R
import com.example.android7.ToDoList.DTO.ToDo
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    lateinit var dbHandler: DBHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        setSupportActionBar(dashboard_toolbar)
        title = "Dashboard"

        dbHandler = DBHandler(this)

        //리사이클러뷰에 대한 레이아웃 관리자 설정
        rv_dashboard.layoutManager = LinearLayoutManager(this)

        fab_dashboard.setOnClickListener{
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Add ToDo")
            val view = layoutInflater.inflate(R.layout.dialog_dashboard, null)
            val toDoName = view.findViewById<EditText>(R.id.ev_todo)
            dialog.setView(view)
            dialog.setPositiveButton("Add") {_:DialogInterface, _: Int->
                if(toDoName.text.isNotEmpty()){
                    val toDo = ToDo()
                    toDo.name = toDoName.text.toString()
                    dbHandler.addToDo(toDo)
                    refreshList()
                }
            }
            dialog.setNegativeButton("Cancel") {_:DialogInterface, _: Int ->

            }
            dialog.show()
        }
    }

    //목록을 연다.
    override fun onResume(){
        refreshList()
        super.onResume()
    }


    //항목을 추가한 후에는 리사이클러뷰를 새로고침
    private  fun refreshList(){
        rv_dashboard.adapter = DashboardAdapter(this, dbHandler.getToDos())
    }


    //리사이클러뷰를 위한 adapter 생성
    class DashboardAdapter(val activity: DashboardActivity, val list : MutableList<ToDo>) : RecyclerView.Adapter<DashboardAdapter.ViewHolder>(){
        //내부에 viewholder 생성
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(activity).inflate(R.layout.rv_child_dashboard, parent, false))
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.toDoName.text = list[position].name
        }

        class ViewHolder(v : View) : RecyclerView.ViewHolder(v) {
            val toDoName : TextView = v.findViewById(R.id.tv_todo_name)
        }


    }

}