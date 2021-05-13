package com.example.charactercreator.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity

import androidx.recyclerview.widget.RecyclerView
import com.example.charactercreator.CharacterStats
import com.example.charactercreator.Current_Name
import com.example.charactercreator.R
import kotlinx.android.synthetic.main.list_item.view.*


class MyAdapter (var context: Context, var arrayList: ArrayList<String>):
        RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder?.itemType?.text = arrayList[position]
        holder.itemType.setOnClickListener {
            Current_Name = holder.itemType.text as String
            var intent = Intent(context, CharacterStats::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}
class ViewHolder(view: View): RecyclerView.ViewHolder(view){
    val itemType = view.text_item
}