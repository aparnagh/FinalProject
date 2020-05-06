package com.example.finalproject

import android.graphics.Color
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
class q12 : Fragment() {

    lateinit var model: MyViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        model = activity!!.let { ViewModelProviders.of(it).get(MyViewModel::class.java)}
        val view = inflater.inflate(R.layout.fragment_q12, container, false)

        view!!.findViewById<Button>(R.id.home12).setOnClickListener{
            view!!.findNavController().navigate(R.id.action_q12_to_home)
        }

        view!!.findViewById<Button>(R.id.prev_button12).setOnClickListener{
            view!!.findNavController().navigate(R.id.action_q12_to_q11)
        }

        view!!.findViewById<Button>(R.id.next_button12).setOnClickListener{
            if ( model!!.answers.value!!.numAnswers >= 12) { //make toast if not 1
                view!!.findNavController().navigate(R.id.action_q12_to_home)
                Toast.makeText(activity as MainActivity, "Great job! You completed your daily survey. Click 'Track Progress' to see more details.", Toast.LENGTH_LONG).show()
            }
            else {//make toast if not 2
                Toast.makeText(activity as MainActivity, "Please answer the question before moving on!", Toast.LENGTH_LONG).show()

            }
        }

        view!!.findViewById<Button>(R.id.strAgree_button12).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 12) {
                model!!.answers.value!!.numAnswers = 12
            }
            resetButtons(view)
            view!!.findViewById<Button>(R.id.strAgree_button12).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.agree_button12).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 12) {
                model!!.answers.value!!.numAnswers = 12
            }
            resetButtons(view)
            view!!.findViewById<Button>(R.id.agree_button12).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.neutral_button12).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 12) {
                model!!.answers.value!!.numAnswers = 12
            }
            resetButtons(view)
            view!!.findViewById<Button>(R.id.neutral_button12).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.dislike_button12).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 12) {
                model!!.answers.value!!.numAnswers = 12
            }
            resetButtons(view)
            view!!.findViewById<Button>(R.id.dislike_button12).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.strDislike_button12).setOnClickListener{
           if(model!!.answers.value!!.numAnswers < 12) {
                model!!.answers.value!!.numAnswers = 12
            }
            resetButtons(view)
            view!!.findViewById<Button>(R.id.strDislike_button12).setBackgroundColor(Color.rgb(157,143,247))
        }
        return view
    }

    private fun resetButtons(view: View){
        view.findViewById<Button>(R.id.strAgree_button12).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.agree_button12).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.neutral_button12).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.dislike_button12).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.strDislike_button12).setBackgroundColor(Color.LTGRAY)
        model.addToDB()
    }
}
