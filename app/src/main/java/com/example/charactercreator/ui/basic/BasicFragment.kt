package com.example.charactercreator.ui.basic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.charactercreator.R

class BasicFragment : Fragment() {

    private lateinit var basicViewModel: BasicViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        basicViewModel =
            ViewModelProvider(this).get(BasicViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_basic, container, false)
        //val textView: TextView = root.findViewById(R.id.text_basic)
//        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }
}