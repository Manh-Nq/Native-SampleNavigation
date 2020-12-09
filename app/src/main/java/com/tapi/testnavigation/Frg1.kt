package com.tapi.testnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Frg1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Frg1 : Fragment() {
    private lateinit var bt1: Button
    private lateinit var rootView: View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView =
            LayoutInflater.from(requireContext()).inflate(R.layout.fragment_frg1, container, false)
        // Inflate the layout for this fragment
        bt1 = rootView.findViewById(R.id.bt_1)
        bt1.setOnClickListener {
             findNavController().navigate(R.id.action_frg1_to_frg2)

        }
        return rootView
    }


}