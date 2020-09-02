package com.example.testsqlite

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), ListAdapter.OnClick {
    val dbHelper = DatabaseTestHelper(this, "testDB.db", 1)
     var list = ArrayList<set>()
     var adapter : ListAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        creatDatabase.setOnClickListener {
            dbHelper.writableDatabase
        }
        addData.setOnClickListener {
            val db = dbHelper.writableDatabase
            val value1 = ContentValues().apply {
                put("name", "aaaaa")
                put("ecuID2", "")
                put("longString", "111111111111111")
                put("reservedID", "")
                put("reservedID2", "")
            }
            db.insert("Book", null, value1)
            val value2 = ContentValues().apply {
                put("name", "bbbbbbbbb")
                put("ecuID2", "")
                put("longString", "2222222222222222222")
                put("reservedID", "")
                put("reservedID2", "")
            }
            db.insert("Book", null, value2)
            val value3 = ContentValues().apply {
                put("name", "ccccccccc")
                put("ecuID2", "")
                put("longString", "2222222222222222222")
                put("reservedID", "")
                put("reservedID2", "")
            }
            db.insert("Book", null, value3)
        }
        xianshi.setOnClickListener {
            initView()
        }


    }
    private fun initView() {
        list.clear()
        initData()
        adapter = ListAdapter(this, R.layout.list_item, list)
        adapter!!.setClick(this)
        ListView.adapter = adapter
    }
    private fun initData(){
        val db = dbHelper.writableDatabase
        val cursor = db.query("Book", null, null, null, null, null, null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex("id"))
                val name = cursor.getString(cursor.getColumnIndex("name"))
                val longString = cursor.getString(cursor.getColumnIndex("longString"))
                val set = set(id, name, longString, "", "")
                list.add(set)
            } while (cursor.moveToNext())

        }
        cursor.close()
    }

    override fun setonClick() {
        initView()
    }
}