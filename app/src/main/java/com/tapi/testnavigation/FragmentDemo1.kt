package com.tapi.testnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentDemo1.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentDemo1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var btGo: Button
    private lateinit var btGoFrg: Button
    private lateinit var edt1: EditText
    private lateinit var rootView: View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView =
            LayoutInflater.from(requireContext()).inflate(R.layout.fragment_demo1, container, false)
        initViews()
        return rootView
    }

    private fun initViews() {
        btGo = rootView.findViewById(R.id.bt_1)
        btGoFrg = rootView.findViewById(R.id.bt_frg)
        edt1 = rootView.findViewById(R.id.edt_1)
        btGo.setOnClickListener {
            val action = FragmentDemo1Directions.frg1GotoFrg2(5)
            findNavController().navigate(action)

        }
        btGoFrg.setOnClickListener {
            val action = FragmentDemo1Directions.actionFragmentDemo1ToFrgMain()
            findNavController().navigate(action)
        }
    }

}