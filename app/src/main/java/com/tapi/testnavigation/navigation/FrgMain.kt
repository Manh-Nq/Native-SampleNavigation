package com.tapi.testnavigation.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.tapi.testnavigation.R

class FrgMain : Fragment() {
    private lateinit var bt1: Button
    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_frg_main, container, false)
        // Inflate the layout for this fragment

        return rootView
    }

}