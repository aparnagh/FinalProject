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
class Q2 : Fragment() {

    lateinit var model: MyViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        model = ViewModelProviders.of(activity!!).get(MyViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_q2, container, false)

        if(model!!.getNumAnswers() >= 2){
            if(model!!.highlightAns[5]){
                view!!.findViewById<Button>(R.id.strAgree_button2).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[6]){
                view!!.findViewById<Button>(R.id.agree_button2).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[7]){
                view!!.findViewById<Button>(R.id.neutral_button2).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[8]){
                view!!.findViewById<Button>(R.id.dislike_button2).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[9]){
                view!!.findViewById<Button>(R.id.strDislike_button2).setBackgroundColor(Color.rgb(157,143,247))
            }
        }

        view!!.findViewById<Button>(R.id.home2).setOnClickListener{
            view!!.findNavController().navigate(R.id.action_q2_to_home)
        }

        view!!.findViewById<Button>(R.id.prev_button2).setOnClickListener{
            view!!.findNavController().navigate(R.id.action_q2_to_q1)
        }

        view!!.findViewById<Button>(R.id.next_button2).setOnClickListener{
            if ( model!!.answers.value!!.numAnswers >= 2) { //make toast if not 1
                view!!.findNavController().navigate(R.id.action_q2_to_q3)
            }
            else {//make toast if not 2
                Toast.makeText(activity as MainActivity, "Please answer the question before moving on!", Toast.LENGTH_LONG).show()

            }
        }

        view!!.findViewById<Button>(R.id.strAgree_button2).setOnClickListener{
            if(model!!.answers.value!!.numAnswers < 2) {
                model!!.answers.value!!.numAnswers = 2
            }
            resetButtons(view)
            setHighlight(1)
            view!!.findViewById<Button>(R.id.strAgree_button2).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.agree_button2).setOnClickListener{
            if(model!!.answers.value!!.numAnswers < 2) {
                model!!.answers.value!!.numAnswers = 2
            }
            resetButtons(view)
            setHighlight(2)
            view!!.findViewById<Button>(R.id.agree_button2).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.neutral_button2).setOnClickListener{
            if(model!!.answers.value!!.numAnswers < 2) {
                model!!.answers.value!!.numAnswers = 2
            }
            resetButtons(view)
            setHighlight(3)
            view!!.findViewById<Button>(R.id.neutral_button2).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.dislike_button2).setOnClickListener{
            if(model!!.answers.value!!.numAnswers < 2) {
                model!!.answers.value!!.numAnswers = 2
            }
            resetButtons(view)
            setHighlight(4)
            view!!.findViewById<Button>(R.id.dislike_button2).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.strDislike_button2).setOnClickListener{
            if(model!!.answers.value!!.numAnswers < 2) {
                model!!.answers.value!!.numAnswers = 2
            }
            setHighlight(5)
            resetButtons(view)
            view!!.findViewById<Button>(R.id.strDislike_button2).setBackgroundColor(Color.rgb(157,143,247))
        }

        return view
    }


    private fun resetButtons(view: View){
        view.findViewById<Button>(R.id.strAgree_button2).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.agree_button2).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.neutral_button2).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.dislike_button2).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.strDislike_button2).setBackgroundColor(Color.LTGRAY)
    }

    private fun setHighlight(num: Int){

        if(num == 1){
            model!!.highlightAns[5] = true
            model!!.highlightAns[6] = false
            model!!.highlightAns[7] = false
            model!!.highlightAns[8] = false
            model!!.highlightAns[9] = false
        }
        else if(num == 2){
            model!!.highlightAns[5] = false
            model!!.highlightAns[6] = true
            model!!.highlightAns[7] = false
            model!!.highlightAns[8] = false
            model!!.highlightAns[9] = false
        }
        else if(num == 3){
            model!!.highlightAns[5] = false
            model!!.highlightAns[6] = false
            model!!.highlightAns[7] = true
            model!!.highlightAns[8] = false
            model!!.highlightAns[9] = false
        }
        else if(num == 4){
            model!!.highlightAns[5] = false
            model!!.highlightAns[6] = false
            model!!.highlightAns[7] = false
            model!!.highlightAns[8] = true
            model!!.highlightAns[9] = false
        }
        else if(num == 5){
            model!!.highlightAns[5] = false
            model!!.highlightAns[6] = false
            model!!.highlightAns[7] = false
            model!!.highlightAns[8] = false
            model!!.highlightAns[9] = true
        }
    }

}
