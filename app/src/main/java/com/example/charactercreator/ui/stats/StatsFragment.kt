package com.example.charactercreator.ui.stats

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

class StatsFragment : Fragment() {

    private lateinit var statsViewModel: StatsViewModel


    lateinit var strength: EditText
    lateinit var wisdom: EditText
    lateinit var stamina: EditText
    lateinit var charisma: EditText
    lateinit var speed: EditText
    lateinit var stealth: EditText
    lateinit var karma: EditText
    lateinit var hp: EditText
    lateinit var mp: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        statsViewModel =
            ViewModelProvider(this).get(StatsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_stats, container, false)

        val SP6 = this.activity?.getSharedPreferences(Current_Name, AppCompatActivity.MODE_PRIVATE)

        strength = root.findViewById<EditText>(R.id.idStrengthStat)
        SP6?.getString("strength", "")?.let { strength.setText(it) }

        wisdom = root.findViewById<EditText>(R.id.idWisdomStat)
        SP6?.getString("wisdom", "")?.let { wisdom.setText(it) }

        stamina = root.findViewById<EditText>(R.id.idStaminaStat)
        SP6?.getString("stamina", "")?.let { stamina.setText(it) }

        charisma = root.findViewById<EditText>(R.id.idCharismaStat)
        SP6?.getString("charisma", "")?.let { charisma.setText(it) }

        speed = root.findViewById<EditText>(R.id.idSpeedStat)
        SP6?.getString("speed", "")?.let { speed.setText(it) }

        stealth = root.findViewById<EditText>(R.id.idStealthStat)
        SP6?.getString("stealth", "")?.let { stealth.setText(it) }

        karma = root.findViewById<EditText>(R.id.idKarmaStat)
        SP6?.getString("karma", "")?.let { karma.setText(it) }

        hp = root.findViewById<EditText>(R.id.idHealthStat)
        SP6?.getString("hp", "")?.let { hp.setText(it) }

        mp = root.findViewById<EditText>(R.id.idMagicStat)
        SP6?.getString("mp", "")?.let { mp.setText(it) }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        val editor = this.activity?.getSharedPreferences(Current_Name, AppCompatActivity.MODE_PRIVATE)?.edit()

        editor?.apply{
            putString("strength", strength.text.toString())
            putString("wisdom", wisdom.text.toString())
            putString("stamina", stamina.text.toString())
            putString("charisma", charisma.text.toString())
            putString("speed", speed.text.toString())
            putString("stealth", stealth.text.toString())
            putString("karma", karma.text.toString())
            putString("hp", hp.text.toString())
            putString("mp", mp.text.toString())
            apply()
        }
    }
}