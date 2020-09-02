package com.example.testsqlite

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView

class ListAdapter(activity: Activity, val resourseID: Int, data: List<set>) : ArrayAdapter<set>(
    activity,
    resourseID,
    data
) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourseID, parent, false)
            val name: TextView = view.findViewById(R.id.item)
            val btn: Button = view.findViewById(R.id.delete)
            viewHolder = ViewHolder(name, btn)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }


        val listItem = getItem(position)
        if (listItem != null){
           viewHolder.name.text = listItem.name + listItem.longString
            viewHolder.btn.setOnClickListener {
                val dbHelper = DatabaseTestHelper(context, "testDB.db", 1)
                val db = dbHelper.writableDatabase
                db.execSQL("delete from Book where id = ?", arrayOf(listItem.id))
                checked.setonClick()
            }
        }
        return view
    }
    interface OnClick {
        fun setonClick()
    }
    private lateinit var checked: OnClick

    fun setClick(onClick: OnClick) {
        this.checked = onClick
    }
    inner class ViewHolder(val name: TextView, val btn: Button)
}