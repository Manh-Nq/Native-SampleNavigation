package com.tapi.testnavigation.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tapi.testnavigation.R
import com.tapi.testnavigation.viewmodel.MyViewModel


class FragmentDemo1 : Fragment() {

    private val TAG: String = "nmcode"
    private lateinit var btGo: Button
    private lateinit var btGoFrg: Button
    private lateinit var tvCount: TextView
    private lateinit var rootView: View
    private lateinit var viewModel: MyViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        rootView =
            LayoutInflater.from(requireContext()).inflate(R.layout.fragment_demo1, container, false)
        initViews()

        viewModel.number.observe(viewLifecycleOwner, Observer {
            tvCount.text = "$it Con vịt "
        })

        return rootView
    }

    private fun initViews() {
        btGo = rootView.findViewById(R.id.bt_1)
        btGoFrg = rootView.findViewById(R.id.bt_frg)

        tvCount = rootView.findViewById(R.id.tv_count)
        btGo.setOnClickListener {
            /*  val action = FragmentDemo1Directions.frg1GotoFrg2(5)
              findNavController().navigate(action)*/
            viewModel.start()

        }
        btGoFrg.setOnClickListener {
           /* val action = FragmentDemo1Directions.actionFragmentDemo1ToFrgMain()
            findNavController().navigate(action)*/
        }

    }

}