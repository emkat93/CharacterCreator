package com.example.charactercreator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class Settings : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    val Pref_Name = "perfs"
    val Pref_Dark_Theme = "dark_theme"

    lateinit var name: EditText
    lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {

        val SP2 = getSharedPreferences(Pref_Name, MODE_PRIVATE)
        useDarkTheme = SP2.getBoolean(Pref_Dark_Theme, false)

        if (useDarkTheme){
            setTheme(R.style.ThemeOverlay_AppCompat_Dark)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        name = findViewById<EditText>(R.id.idName)
        name.setText(SP2.getString("name", " "))

        val toggle = findViewById<Switch>(R.id.switch1)
        toggle.isChecked = useDarkTheme
        toggle.setOnCheckedChangeListener{ view, isChecked -> toggleTheme(isChecked)
        }

        spinner = findViewById<Spinner>(R.id.spinner1)
        spinner.onItemSelectedListener = this

        val selectedPosition = spinner.selectedItemPosition
        spinner.setSelection(SP2.getInt("spinnerSelection", 0))

        ArrayAdapter.createFromResource(
                this,
                R.array.versions,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            spinner.adapter = adapter
        }

        //Button that saves out info
        val save_btn = findViewById<Button>(R.id.button)
        save_btn.setOnClickListener {
            val editor = getSharedPreferences(Pref_Name, MODE_PRIVATE).edit()

            editor.apply {
                putString("name", name.text.toString())
                putInt("spinnerSelection", selectedPosition)
                apply ()
            }
            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)
        }
    }

    private fun toggleTheme(darkTheme: Boolean) {
        val editor = getSharedPreferences(Pref_Name, MODE_PRIVATE).edit()

        editor.apply {
            putBoolean(Pref_Dark_Theme, darkTheme)
            apply ()
        }

        val intent = intent
        finish()
        startActivity(intent)
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }


}