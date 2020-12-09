package com.tapi.testnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class FragmentDemo2 : Fragment() {
    private var num: Int = 0

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var btGo: Button
    private lateinit var tv2: TextView
    private lateinit var rootView: View
    private val args: FragmentDemo2Args by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView =
            LayoutInflater.from(requireContext()).inflate(R.layout.fragment_demo2, container, false)
        // Inflate the layout for this fragment
        num = args.dataFrom1
        initViews()
        return rootView
    }


    private fun initViews() {
        btGo = rootView.findViewById(R.id.bt_go)
        tv2 = rootView.findViewById(R.id.tv_2)
        tv2.text = num.toString()
        btGo.setOnClickListener {
            val action = FragmentDemo2Directions.frg2GotoFrg3(
                mutableListOf(
                    "hello",
                    "continue",
                    "ahahaaha"
                ).toTypedArray()
            )
            findNavController().navigate(action)
        }

    }

}