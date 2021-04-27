package com.example.charactercreator.ui.extra

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.charactercreator.Current_Name
import com.example.charactercreator.R

class ExtraFragment : Fragment() {

    private lateinit var extraViewModel: ExtraViewModel


    lateinit var birthDate: EditText
    lateinit var placeOfBirth: EditText
    lateinit var charInfo: EditText

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        extraViewModel = ViewModelProvider(this).get(ExtraViewModel::class.java)
        val root = inflater.inflate(R.layout.extra_fragment, container, false)

        val SP4 = this.activity?.getSharedPreferences(Current_Name, AppCompatActivity.MODE_PRIVATE)

        birthDate = root.findViewById<EditText>(R.id.idDate)
        SP4?.getString("date", "")?.let { birthDate.setText(it) }

        placeOfBirth = root.findViewById<EditText>(R.id.idPlaceOfBirth)
        placeOfBirth.setText(SP4?.getString("place of birth", ""))

        charInfo = root.findViewById<EditText>(R.id.idMultiLine)
        charInfo.setText(SP4?.getString("info", ""))

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        val editor = this.activity?.getSharedPreferences(Current_Name, AppCompatActivity.MODE_PRIVATE)?.edit()

        editor?.apply{
            putString("date", birthDate.text.toString())
            putString("place of birth", placeOfBirth.text.toString())
            putString("info", charInfo.text.toString())
            apply()
        }
    }
}