package com.tapi.testnavigation.navigation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tapi.testnavigation.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Frg2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Frg2 : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var bt1: Button
    private lateinit var rootView: View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView =
            LayoutInflater.from(requireContext()).inflate(R.layout.fragment_frg2, container, false)
        // Inflate the layout for this fragment
        bt1 = rootView.findViewById(R.id.bt_2)
        bt1.setOnClickListener {
            findNavController().navigate(R.id.frg2_backto1)
        }
        return rootView
    }

    override fun onAttach(context: Context) {
        Log.d("TAG", "nmLOG_fr2   onAttach: ${this.javaClass.name}")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("TAG", "nmLOG_fr2    onCreate: ${this.javaClass.name}")
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG", "nmLOG_fr2    onStart: ${this.javaClass.name}")
    }

    override fun onResume() {
        Log.d("TAG", "nmLOG_fr2    onResume: ${this.javaClass.name}")
        super.onResume()
    }

    override fun onPause() {
        Log.d("TAG", "nmLOG_fr2   onPause: ${this.javaClass.name}")
        super.onPause()
    }

    override fun onStop() {
        Log.d("TAG", "nmLOG_fr2    onStop: ${this.javaClass.name}")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("TAG", "nmLOG_fr2    onDestroyView: ${this.javaClass.name}")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("TAG", "nmLOG_fr2    onDestroy: ${this.javaClass.name}")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d("TAG", "nmLOG_fr2    onDetach: ${this.javaClass.name}")
        super.onDetach()
    }


}