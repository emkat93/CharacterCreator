package com.example.charactercreator.ui.extra

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.charactercreator.R

class ExtraFragment : Fragment() {

    companion object {
        fun newInstance() = ExtraFragment()
    }

    private lateinit var extraViewModel: ExtraViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        extraViewModel = ViewModelProvider(this).get(ExtraViewModel::class.java)
        return inflater.inflate(R.layout.extra_fragment, container, false)
    }


}