package com.example.android7.ToDoList

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.android7.ToDoList.DTO.ToDo
import com.example.android7.ToDoList.DTO.ToDoItem

class DBHandler(val context: Context):SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION){
    override fun onCreate(db: SQLiteDatabase) {
        val createToDoTable = "  CREATE TABLE $TABLE_TODO (" +
                "$COL_ID integer PRIMARY KEY AUTOINCREMENT," +
                "$COL_CREATED_AT datetime DEFAULT CURRENT_TIMESTAMP," +
                "$COL_NAME varchar);"
        val createToDoItemTable =
                "CREATE TABLE $TABLE_TODO_ITEM (" +
                        "$COL_ID integer PRIMARY KEY AUTOINCREMENT," +
                        "$COL_CREATED_AT datetime DEFAULT CURRENT_TIMESTAMP," +
                        "$COL_TODO_ID integer," +
                        "$COL_ITEM_NAME varchar," +
                        "$COL_IS_COMPLETED integer);"

        db.execSQL(createToDoTable)
        db.execSQL(createToDoItemTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun  addToDo(toDo: ToDo) : Boolean{     //반환유형을 Boolean -> 호출 클래스에 삽입 상태를 제공할 수 있게 한다
       //데이터를 삽입하여 writableDatabase를 얻는다.
        val db=writableDatabase
        //contentvalues를 만들고 그 안에 COL_NAME 넣는다.
        val cv = ContentValues()
        cv.put(COL_NAME, toDo.name)
        val result = db.insert(TABLE_TODO, null, cv)
        return result != (-1).toLong()

    }

    //항목 목록을 가져오자.
    fun getToDos() : MutableList<ToDo>{
        //변경 가능한 목록을 만들고 반환하는 항목을 저장하기 위해
        val result : MutableList<ToDo> = ArrayList()
        val db = readableDatabase
        val queryResult = db.rawQuery("SELECT * from $TABLE_TODO", null)

        if(queryResult.moveToFirst()) {
            do {
                val todo = ToDo()
                todo.id = queryResult.getLong(queryResult.getColumnIndex(COL_ID))
                todo.name = queryResult.getString(queryResult.getColumnIndex(COL_NAME))
                result.add(todo)

            }   while (queryResult.moveToNext())
        }

        queryResult.close()
        return result
    }

}