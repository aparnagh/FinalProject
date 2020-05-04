package com.example.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController

/**
 * A simple [Fragment] subclass.
 */
class Q9 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val model = activity?.let { ViewModelProviders.of(it).get(MyViewModel::class.java)}
        val view = inflater.inflate(R.layout.fragment_q9, container, false)


        view!!.findViewById<Button>(R.id.home9).setOnClickListener{
            view!!.findNavController().navigate(R.id.action_q9_to_home)
        }

        view!!.findViewById<Button>(R.id.prev_button9).setOnClickListener{
            view!!.findNavController().navigate(R.id.action_q9_to_q8)
        }

        view!!.findViewById<Button>(R.id.next_button9).setOnClickListener{
            if ( model!!.answers.value!!.numAnswers >= 9) { //make toast if not 1
                view!!.findNavController().navigate(R.id.action_q9_to_q10)
            }
            else {//make toast if not 2
                Toast.makeText(activity as MainActivity, "Please answer the question before moving on!", Toast.LENGTH_LONG).show()

            }
        }

        view!!.findViewById<Button>(R.id.strAgree_button9).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 9) {
                model!!.answers.value!!.numAnswers = 9
            }
        }

        view!!.findViewById<Button>(R.id.agree_button9).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 9) {
                model!!.answers.value!!.numAnswers = 9
            }
        }

        view!!.findViewById<Button>(R.id.neutral_button9).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 9) {
                model!!.answers.value!!.numAnswers = 9
            }
        }

        view!!.findViewById<Button>(R.id.dislike_button9).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 9) {
                model!!.answers.value!!.numAnswers = 9
            }
        }

        view!!.findViewById<Button>(R.id.strDislike_button9).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 9) {
                model!!.answers.value!!.numAnswers = 9
            }
        }
        return view
    }

}
