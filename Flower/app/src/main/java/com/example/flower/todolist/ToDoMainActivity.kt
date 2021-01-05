package com.example.flower.todolist

import android.graphics.Paint
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flower.R
import com.example.flower.databinding.ActivityMainBinding
import com.example.flower.databinding.ActivityToDoMainBinding
import com.example.flower.databinding.TodolistBinding

class ToDoMainActivity : AppCompatActivity() {

    private val data = ArrayList<TodoList>()
    private lateinit var binding: ActivityToDoMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToDoMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@ToDoMainActivity)
            adapter = TodoAdapter(data,
                onClickDeleteIcon ={deleteTodo(it)
                },
                onClickItem = {
                    toggleTodo(it)
                }
            )
        }

        binding.btnAdd.setOnClickListener{
            addTodo()
        }

    }

    private fun toggleTodo(todo: TodoList) {
        todo.isDone = !todo.isDone
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }

    private fun addTodo(){
        val todo = TodoList(binding.eteditText.text.toString())
        data.add(todo)
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }

    private fun deleteTodo(todo: TodoList) {
        data.remove(todo)
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }
}

data class TodoList(val text: String, var isDone:Boolean=false)

class TodoAdapter(private val myDataset: ArrayList<TodoList>,
                  val onClickDeleteIcon: (todo:TodoList)-> Unit,
                  val onClickItem: (todo: TodoList)->Unit) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: TodolistBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return TodoViewHolder(TodolistBinding.bind(view))

    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = myDataset[position]
        holder.binding.tvItem.text = todo.text

        if (todo.isDone) {
            holder.binding.tvItem.apply {
                paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                setTypeface(null, Typeface.ITALIC)
            }
        } else {
            holder.binding.tvItem.apply {
                paintFlags = 0
                setTypeface(null, Typeface.NORMAL)
            }

        }

        holder.binding.ivDelete.setOnClickListener {
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