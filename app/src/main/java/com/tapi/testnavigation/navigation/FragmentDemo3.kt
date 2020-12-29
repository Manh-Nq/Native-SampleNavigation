package com.tapi.testnavigation.navigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tapi.testnavigation.R


class FragmentDemo3 : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var btGo: Button
    private lateinit var btBack: Button
    private lateinit var btGlobal: Button
    private lateinit var rootView: View
    private val args: FragmentDemo3Args by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView =
            LayoutInflater.from(requireContext()).inflate(R.layout.fragment_demo3, container, false)
        initViews()
        val arrString = args.ReceiveDataFrom2
        arrString.forEach {
            Log.d("TAG", "onCreateView: $it")
        }
        return rootView
    }


    private fun initViews() {
        btGo = rootView.findViewById(R.id.bt_go)
        btGo.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentDemo3_to_fragmentDemo4)
        }
        btBack = rootView.findViewById(R.id.bt_back)
        btBack.setOnClickListener {
            findNavController().navigate(R.id.frg3_goto_frg1)
        }

    }


}