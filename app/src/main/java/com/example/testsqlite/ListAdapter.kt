package com.example.testsqlite

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ListAdapter(activity: Activity, val resourseID: Int, data: List<String>) : ArrayAdapter<String>(activity, resourseID, data) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(resourseID, parent, false)
        val ecuname: TextView = view.findViewById(R.id.item)
        val ecu = getItem(position)
        if (ecu != null){
           ecuname.text = ecu
        }
        return view
    }
}