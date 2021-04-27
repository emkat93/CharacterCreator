package com.example.charactercreator.ui.basic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.charactercreator.Current_Name
import com.example.charactercreator.R

class BasicFragment : Fragment() {

    private lateinit var basicViewModel: BasicViewModel


    lateinit var charName: EditText
    lateinit var raceSpeciesEthnicity: EditText
    lateinit var charClass: EditText
    lateinit var charAlignment: EditText
    lateinit var gender: EditText
    lateinit var age: EditText
    lateinit var hairColor: EditText
    lateinit var eyeColor: EditText
    lateinit var skinColor: EditText
    lateinit var markings: EditText

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        basicViewModel =
                ViewModelProvider(this).get(BasicViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_basic, container, false)

        val SP3 = this.activity?.getSharedPreferences(Current_Name, AppCompatActivity.MODE_PRIVATE)

        charName = root.findViewById<EditText>(R.id.idCharacterName)
        charName.setText(SP3?.getString("name", ""))

        raceSpeciesEthnicity = root.findViewById<EditText>(R.id.idRSE)
        raceSpeciesEthnicity.setText(SP3?.getString("race/species/ethnicity", ""))

        charClass = root.findViewById<EditText>(R.id.idClass)
        charClass.setText(SP3?.getString("class", ""))

        charAlignment = root.findViewById<EditText>(R.id.idAlignment)
        charAlignment.setText(SP3?.getString("alignment", ""))

        gender = root.findViewById<EditText>(R.id.idGender)
        gender.setText(SP3?.getString("gender", ""))

        age = root.findViewById<EditText>(R.id.idAge)
        age.setText(SP3?.getString("age", ""))

        hairColor = root.findViewById<EditText>(R.id.idHairColor)
        hairColor.setText(SP3?.getString("hair", ""))

        eyeColor = root.findViewById<EditText>(R.id.idEyeColor)
        eyeColor.setText(SP3?.getString("eye", ""))

        skinColor = root.findViewById<EditText>(R.id.idSkinColor)
        skinColor.setText(SP3?.getString("skin", ""))

        markings = root.findViewById<EditText>(R.id.idMarkings)
        markings.setText(SP3?.getString("markings", ""))

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        val editor = this.activity?.getSharedPreferences(Current_Name, AppCompatActivity.MODE_PRIVATE)?.edit()

        editor?.apply {
            putString("name", charName.text.toString())
            putString("race/species/ethnicity", raceSpeciesEthnicity.text.toString())
            putString("class", charClass.text.toString())
            putString("alignment", charAlignment.text.toString())
            putString("gender", gender.text.toString())
            putString("age", age.text.toString())
            putString("hair", hairColor.text.toString())
            putString("eye", eyeColor.text.toString())
            putString("skin", skinColor.text.toString())
            putString("markings", markings.text.toString())
            apply ()
        }
    }
}