package com.example.androidapp.rv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidapp.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_todo.*

class TodoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        var todoList = mutableListOf(
            Todo("Android", false),
            Todo("Kotlin", false),
            Todo("Java", false),
            Todo("Ios", false),
            Todo("Google", false),
            Todo("Apple", false),
            Todo("Flutter", false),
            Todo("Mobile", false),
            Todo("App", false),
            Todo("Tech", false),
        )

        val adapter = TodoAdapter(todoList)
        rvTodo.adapter = adapter
        rvTodo.layoutManager = LinearLayoutManager(this)

        btnTodo.setOnClickListener {
            val title = etTodo.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size-1)
        }
    }
}