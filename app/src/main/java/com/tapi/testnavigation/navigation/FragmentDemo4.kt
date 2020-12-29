package com.tapi.testnavigation.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tapi.testnavigation.R

class FragmentDemo4 : Fragment() {
    private lateinit var btGo: Button
    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView =
            LayoutInflater.from(requireContext()).inflate(R.layout.fragment_demo4, container, false)
        // Inflate the layout for this fragment
        initViews()
        return rootView
    }

    private fun initViews() {
        btGo = rootView.findViewById(R.id.bt_goto)
        btGo.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentDemo4_to_fragmentDemo1)
        }
    }

}