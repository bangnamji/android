package com.example.project

import android.graphics.Paint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.databinding.ActivityMainBinding
import com.example.project.databinding.TodolistBinding

class MainActivity : AppCompatActivity() {
    private val data = ArrayList<TodoList>()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.recyclerView.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)

            adapter = TodoAdapter(data,
                    onClickDeleteIcon = {
                        deleteTodo(it)
                    },
                    onClickItem = {
                        toggleTodo(it)
                    }

            )
        }

        binding.addButton.setOnClickListener {
            addTodo()
        }

    }

    //할 일 완료 기능 -> 할 일을 선택하면 !todo.isDone으로 변경된다.
    private fun toggleTodo(todo: TodoList) {
        todo.isDone = !todo.isDone
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }

    //할 일 추가 기능 -> 변경된 데이터를 어댑터에 전달한다.
    private fun addTodo() {
        val todo = TodoList(binding.editText.text.toString())
        data.add(todo)
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }

    //삭제 기능
    private fun deleteTodo(todo: TodoList) {
        data.remove(todo)
        binding.recyclerView.adapter?.notifyDataSetChanged()

    }
}


data class TodoList(
        val text: String,
        var isDone: Boolean=false
)

//Unit은 리턴값이 없는 함수수
class TodoAdapter(
        private val myDataset: ArrayList<TodoList>,
        val onClickDeleteIcon: (todo: TodoList) -> Unit,
        val onClickItem: (todo: TodoList) -> Unit) :
        RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: TodolistBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.todolist, parent, false)
        return TodoViewHolder(TodolistBinding.bind(view))

    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = myDataset[position]
        holder.binding.todoText.text = todo.text

        //만약 할 일을 완료했다면
        if (todo.isDone) {
            holder.binding.todoText.apply {
                paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                setTypeface(null, Typeface.ITALIC)
            }
        } else {
            holder.binding.todoText.apply {
                paintFlags = 0
                setTypeface(null, Typeface.NORMAL)
            }

        }

        holder.binding.deleteImageView.setOnClickListener {
            onClickDeleteIcon.invoke(todo)
        }
        holder.binding.root.setOnClickListener {
            onClickItem.invoke(todo)
        }
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

}