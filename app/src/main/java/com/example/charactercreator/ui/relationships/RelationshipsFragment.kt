package com.example.charactercreator.ui.relationships

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.charactercreator.Current_Name
import com.example.charactercreator.R

class RelationshipsFragment : Fragment() {

    private lateinit var relationshipsViewModel: RelationshipsViewModel


    lateinit var mother: EditText
    lateinit var father: EditText
    lateinit var sister: EditText
    lateinit var brother: EditText
    lateinit var grandpa: EditText
    lateinit var grandma: EditText
    lateinit var aunt: EditText
    lateinit var uncle: EditText
    lateinit var cousin: EditText
    lateinit var friend: EditText
    lateinit var boyGirlFriend: EditText
    lateinit var spouse: EditText
    lateinit var rival : EditText

    lateinit var momStatus: Switch
    lateinit var dadStatus: Switch
    lateinit var sisterStatus: Switch
    lateinit var brotherStatus: Switch
    lateinit var grandpaStatus: Switch
    lateinit var grandmaStatus: Switch
    lateinit var auntStatus: Switch
    lateinit var uncleStatus: Switch
    lateinit var cousinStatus: Switch
    lateinit var friendStatus: Switch
    lateinit var boyGirlFriendStatus: Switch
    lateinit var spouseStatus: Switch
    lateinit var rivalStatus: Switch

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        relationshipsViewModel =
            ViewModelProvider(this).get(RelationshipsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_relationships, container, false)

        val SP5 = this.activity?.getSharedPreferences(Current_Name, AppCompatActivity.MODE_PRIVATE)

        mother = root.findViewById<EditText>(R.id.idMother)
        mother.setText(SP5?.getString("mother", ""))

        father = root.findViewById<EditText>(R.id.idFather)
        father.setText(SP5?.getString("father", ""))

        sister = root.findViewById<EditText>(R.id.idSister)
        sister.setText(SP5?.getString("sister", ""))

        brother = root.findViewById<EditText>(R.id.idBrother)
        brother.setText(SP5?.getString("brother", ""))

        grandpa = root.findViewById<EditText>(R.id.idGrandpa)
        grandpa.setText(SP5?.getString("grandpa", ""))

        grandma = root.findViewById<EditText>(R.id.idGrandma)
        grandma.setText(SP5?.getString("grandma", ""))

        aunt = root.findViewById<EditText>(R.id.idAunt)
        aunt.setText(SP5?.getString("aunt", ""))

        uncle = root.findViewById<EditText>(R.id.idUncle)
        uncle.setText(SP5?.getString("uncle", ""))

        cousin = root.findViewById<EditText>(R.id.idCousin)
        cousin.setText(SP5?.getString("cousin", ""))

        friend = root.findViewById<EditText>(R.id.idFriend)
        friend.setText(SP5?.getString("friend", ""))

        boyGirlFriend = root.findViewById<EditText>(R.id.idB_GFriend)
        boyGirlFriend.setText(SP5?.getString("boy/girl friend", ""))

        spouse = root.findViewById<EditText>(R.id.idSpouse)
        spouse.setText(SP5?.getString("spouse", ""))
        rival = root.findViewById<EditText>(R.id.idRival)
        rival.setText(SP5?.getString("rival", ""))


        momStatus = root.findViewById<Switch>(R.id.idRelationshipStatusMom)
        var onOff1 = SP5?.getBoolean("Mom Status", false)
        momStatus.isChecked = !onOff1!!

        dadStatus = root.findViewById<Switch>(R.id.idRelationshipStatusDad)
        onOff1 = SP5?.getBoolean("Dad Status", false)
        dadStatus.isChecked = !onOff1!!

        sisterStatus = root.findViewById<Switch>(R.id.idRelationshipStatusSister)
        onOff1 = SP5?.getBoolean("Sister Status", false)
        sisterStatus.isChecked = !onOff1!!

        brotherStatus = root.findViewById<Switch>(R.id.idRelationshipStatusBrother)
        onOff1 = SP5?.getBoolean("Brother Status", false)
        brotherStatus.isChecked = !onOff1!!

        grandpaStatus = root.findViewById<Switch>(R.id.idRelationshipStatusGrandpa)
        onOff1 = SP5?.getBoolean("Grandpa Status", false)
        grandpaStatus.isChecked = !onOff1!!

        grandmaStatus = root.findViewById<Switch>(R.id.idRelationshipStatusGrandma)
        onOff1 = SP5?.getBoolean("Grandma Status", false)
        grandmaStatus.isChecked = !onOff1!!

        auntStatus = root.findViewById<Switch>(R.id.idRelationshipStatusAunt)
        onOff1 = SP5?.getBoolean("Aunt Status", false)
        auntStatus.isChecked = !onOff1!!

        uncleStatus = root.findViewById<Switch>(R.id.idRelationshipStatusUncle)
        onOff1 = SP5?.getBoolean("Uncle Status", false)
        uncleStatus.isChecked = !onOff1!!

        cousinStatus = root.findViewById<Switch>(R.id.idRelationshipStatusCousin)
        onOff1 = SP5?.getBoolean("Cousin Status", false)
        cousinStatus.isChecked = !onOff1!!

        friendStatus = root.findViewById<Switch>(R.id.idRelationshipStatusFriend)
        onOff1 = SP5?.getBoolean("Friend Status", false)
        friendStatus.isChecked = !onOff1!!

        boyGirlFriendStatus = root.findViewById<Switch>(R.id.idRelationshipStatusB_GFriend)
        onOff1 = SP5?.getBoolean("Boy/GirlFriend Status", false)
        boyGirlFriendStatus.isChecked = !onOff1!!

        spouseStatus = root.findViewById<Switch>(R.id.idRelationshipStatusSpouse)
        onOff1 = SP5?.getBoolean("Spouse Status", false)
        spouseStatus.isChecked = !onOff1!!

        rivalStatus = root.findViewById<Switch>(R.id.idRelationshipStatusRival)
        onOff1 = SP5?.getBoolean("Rival Status", false)
        rivalStatus.isChecked = !onOff1!!


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        val editor = this.activity?.getSharedPreferences(Current_Name, AppCompatActivity.MODE_PRIVATE)?.edit()

        editor?.apply{
            putString("mother", mother.text.toString())
            putString("father", father.text.toString())
            putString("sister", sister.text.toString())
            putString("brother", brother.text.toString())
            putString("grandpa", grandpa.text.toString())
            putString("grandma", grandma.text.toString())
            putString("aunt", aunt.text.toString())
            putString("uncle", uncle.text.toString())
            putString("cousin", cousin.text.toString())
            putString("friend", friend.text.toString())
            putString("boy/girl friend", boyGirlFriend.text.toString())
            putString("spouse", spouse.text.toString())
            putString("rival", rival.text.toString())

            putBoolean("Mom Status", momStatus.isChecked)
            putBoolean("Dad Status", dadStatus.isChecked)
            putBoolean("Sister Status", sisterStatus.isChecked)
            putBoolean("Brother Status", brotherStatus.isChecked)
            putBoolean("Grandpa Status", grandpaStatus.isChecked)
            putBoolean("Grandma Status", grandmaStatus.isChecked)
            putBoolean("Aunt Status", auntStatus.isChecked)
            putBoolean("Uncle Status", uncleStatus.isChecked)
            putBoolean("Cousin Status", cousinStatus.isChecked)
            putBoolean("Friend Status", friendStatus.isChecked)
            putBoolean("Boy/GirlFriend Status", boyGirlFriendStatus.isChecked)
            putBoolean("Spouse Status", spouseStatus.isChecked)
            putBoolean("Rival Status", rivalStatus.isChecked)
            commit()
        }
    }
}