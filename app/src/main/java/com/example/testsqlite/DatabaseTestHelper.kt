package com.example.testsqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DatabaseTestHelper(val context: Context, name: String, version: Int) : SQLiteOpenHelper(context, name, null, version) {
    private val creatBook = "create table book(" +
            "id integer primary key autoincrement," +
            "name text," +
            "ecuID2 text," +
            "longString text," +
            "reservedID text," +
            "reservedID2 text)"
    override fun onCreate(p0: SQLiteDatabase?) {
        p0!!.execSQL(creatBook)
        Toast.makeText(context, "成功创建", Toast.LENGTH_SHORT).show()
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        if (p1 <= 1){

        }
        if (p1 <= 2) {

        }
    }
}