package com.example.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController

/**
 * A simple [Fragment] subclass.
 */
class Home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        val model = activity?.let { ViewModelProviders.of(it).get(MyViewModel::class.java)}

        view!!.findViewById<Button>(R.id.Assess).setOnClickListener{
            view!!.findNavController().navigate(R.id.action_home_to_q14)
            model!!.answers.value =  SurveyResult(0, "", 0)
        }

       view!!.findViewById<Button>(R.id.PastData).setOnClickListener{
            view!!.findNavController().navigate(R.id.action_home_to_analytics)
        }

        return view
    }



}
