package com.example.testsqlite

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val dbHelper = DatabaseTestHelper(this, "testDB.db", 1)
     var list = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        creatDatabase.setOnClickListener {
            dbHelper.writableDatabase
        }
        addData.setOnClickListener {
            val db = dbHelper.writableDatabase
            val value1 = ContentValues().apply {
                put("ecuID", "aaaaa")
                put("longString", "111111111111111")
                put("reservedID", "")
                put("reservedID2", "")
            }
            db.insert("Book", null, value1)
            val value2 = ContentValues().apply {
                put("ecuID", "bbbbbbbbb")
                put("longString", "2222222222222222222")
                put("reservedID", "")
                put("reservedID2", "")
            }
            db.insert("Book", null, value2)
            val value3 = ContentValues().apply {
                put("ecuID", "ccccccccc")
                put("longString", "2222222222222222222")
                put("reservedID", "")
                put("reservedID2", "")
            }
            db.insert("Book", null, value3)
        }


    }
    private fun initData(){
        val db = dbHelper.writableDatabase
        val cursor = db.query("Book", null, null, null, null, null, null)
        if (cursor.moveToFirst()) {
            do {
                val ecuID = cursor.getString(cursor.getColumnIndex("ecuID"))
                list.add(ecuID)
            } while (cursor.moveToNext())

        }
    }
}