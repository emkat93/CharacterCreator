package com.example.charactercreator.ui.relationships

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.charactercreator.R

class RelationshipsFragment : Fragment() {

    private lateinit var relationshipsViewModel: RelationshipsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        relationshipsViewModel =
            ViewModelProvider(this).get(RelationshipsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_relationships, container, false)
//        val textView: TextView = root.findViewById(R.id.text_notifications)
//        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }
}