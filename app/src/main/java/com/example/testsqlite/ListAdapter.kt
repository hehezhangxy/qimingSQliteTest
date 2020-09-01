package com.example.testsqlite

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView

class ListAdapter(activity: Activity, val resourseID: Int, data: List<String>) : ArrayAdapter<String>(activity, resourseID, data) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourseID, parent, false)
            val ecuname: TextView = view.findViewById(R.id.item)
            val btn: Button = view.findViewById(R.id.delete)
            viewHolder = ViewHolder(ecuname, btn)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }


        val ecu = getItem(position)
        if (ecu != null){
           viewHolder.ecuname.text = ecu
            viewHolder.btn.setOnClickListener {
                val dbHelper = DatabaseTestHelper(context, "Book", 1)
                val db = dbHelper.writableDatabase
                db.delete("Book", "ecuIDecuID = ?", arrayOf("$ecu"))
            }
        }
        return view
    }
    inner class ViewHolder(val ecuname: TextView, val btn: Button)
}