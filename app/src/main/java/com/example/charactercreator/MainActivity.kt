package com.example.charactercreator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

public var useDarkTheme = false

class MainActivity : AppCompatActivity() {

    var listItems = ArrayList<String>()
    var adapter: ArrayAdapter<String>? = null
    lateinit var listView: ListView
    lateinit var undoOnClickListener: View.OnClickListener

    lateinit var fmenu: FloatingActionButton
    lateinit var subMenu1: FloatingActionButton
    lateinit var subMenu2: FloatingActionButton
    lateinit var subMenu3: FloatingActionButton
    lateinit var subMenu4: FloatingActionButton
    var translationYaxis = 100f
    var menuOpen = false

    val Pref_Name = "perfs"
    val Pref_Dark_Theme = "dark_theme"

    override fun onCreate(savedInstanceState: Bundle?) {

        val SP2 = getSharedPreferences(Pref_Name, MODE_PRIVATE)
         useDarkTheme = SP2.getBoolean(Pref_Dark_Theme, false)

        if (useDarkTheme) {
            setTheme(R.style.ThemeOverlay_AppCompat_Dark)
        }
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        initMenu()

        listView = findViewById(R.id.lv1)

        adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                listItems
        )
        listView.adapter = adapter

        undoOnClickListener = View.OnClickListener {  }
    }

    private fun initMenu() {
        fmenu = findViewById(R.id.FABmenu)
        subMenu1 = findViewById(R.id.FABadd)
        subMenu2 = findViewById(R.id.FABremove)
        subMenu3 = findViewById(R.id.FABedit)
        subMenu4 = findViewById(R.id.FABsettings)

        subMenu1.apply {
            translationY = translationYaxis
            alpha = 0f
        }

        subMenu2.apply {
            translationY = translationYaxis
            alpha = 0f
        }

        subMenu3.apply {
            translationY = translationYaxis
            alpha = 0f
        }

        subMenu4.apply {
            translationY = translationYaxis
            alpha = 0f
        }

        fmenu.setOnClickListener{
            if (menuOpen){
                closeTheMenu()
            }else {
                openTheMenu()
            }
        }

        subMenu1.setOnClickListener {
            //call function
            var intent = Intent(this, CharacterStats::class.java)
            closeTheMenu()
            startActivity(intent)
        }

        subMenu2.setOnClickListener {
            //call function
            Toast.makeText(this, "Remove from List", Toast.LENGTH_SHORT).show()
            closeTheMenu()
        }

        subMenu3.setOnClickListener {
            //call function
            Toast.makeText(this, "Edit", Toast.LENGTH_SHORT).show()
            closeTheMenu()
        }

        subMenu4.setOnClickListener {
            //call function
            var intent2 = Intent(this, Settings::class.java)
            closeTheMenu()
            startActivity(intent2)
        }

    }

    private fun openTheMenu() {
        menuOpen = !menuOpen
        fmenu.setImageResource(android.R.drawable.arrow_down_float)
        subMenu1.apply {
            translationY = 0f
            alpha = 1f
        }
        subMenu2.apply {
            translationY = 0f
            alpha = 1f
        }
        subMenu3.apply {
            translationY = 0f
            alpha = 1f
        }
        subMenu4.apply {
            translationY = 0f
            alpha = 1f
        }
    }

    private fun closeTheMenu() {
        menuOpen = !menuOpen
        fmenu.setImageResource(android.R.drawable.arrow_up_float)
        subMenu1.apply {
            translationY = translationYaxis
            alpha = 0f
        }
        subMenu2.apply {
            translationY = translationYaxis
            alpha = 0f
        }
        subMenu3.apply {
            translationY = translationYaxis
            alpha = 0f
        }
        subMenu4.apply {
            translationY = translationYaxis
            alpha = 0f
        }
    }

    private fun addListItem() {
        listItems.add("")
        adapter?.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        Log.i("resume", "resume")
        if (useDarkTheme) {
            setTheme(R.style.ThemeOverlay_AppCompat_Dark)
            val intent = intent
//            finish()
//            startActivity(intent)
        }

    }
}