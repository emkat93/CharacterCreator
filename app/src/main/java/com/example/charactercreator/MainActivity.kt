package com.example.charactercreator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.charactercreator.adapter.MyAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

public var useDarkTheme = false
public var Current_Name = ""

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var arrayList: ArrayList<String>
    lateinit var thisAdapter: MyAdapter

    var listItems: ArrayList<String> = ArrayList()
    var adapter: ArrayAdapter<String>? = null

    lateinit var undoOnClickListener: View.OnClickListener

    lateinit var fmenu: FloatingActionButton
    lateinit var subMenu1: FloatingActionButton
    lateinit var subMenu2: FloatingActionButton
    lateinit var subMenu3: FloatingActionButton
    lateinit var subMenu4: FloatingActionButton
    var translationYaxis = 100f
    var menuOpen = false

    lateinit var addName: EditText
    lateinit var cardview1: ConstraintLayout

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

        cardview1 = findViewById<ConstraintLayout>(R.id.cardView)
        cardview1.isVisible = false


        initMenu()

        recyclerView = findViewById(R.id.rv1)

        recyclerView.layoutManager = LinearLayoutManager(this)

        undoOnClickListener = View.OnClickListener {  }

        arrayList = setupData()
        thisAdapter = MyAdapter(applicationContext, arrayList)
        recyclerView.adapter = thisAdapter
    }

    private fun setupData(): ArrayList<String> {
        var items: ArrayList<String> = ArrayList()

//        val sharedPreferences = getSharedPreferences("perfs", MODE_PRIVATE)
//        val savedString = sharedPreferences.getString(addName.text.toString(), null)

        items.add("Amy")
        items.add("John")
//        items.removeAt(1)

        return items
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
            cardview1.isVisible = true
            var saveName = findViewById<Button>(R.id.idSaveName)
            var cancelSave = findViewById<Button>(R.id.idCancel)

            saveName.setOnClickListener {
//                val editor = getSharedPreferences(Pref_Name, MODE_PRIVATE).edit()

                addName = findViewById<EditText>(R.id.idCharacterName)
//                var items: ArrayList<String> = ArrayList()
                cardview1.isVisible = false

//                editor.apply{
//                    arrayList.add(addName.text.toString())
//                    apply()
//                }
                var intent = Intent(this, CharacterStats::class.java)
                closeTheMenu()
                startActivity(intent)
            }

            cancelSave.setOnClickListener {
                cardview1.isVisible = false
            }

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