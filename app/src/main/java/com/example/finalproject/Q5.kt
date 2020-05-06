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
class Q5 : Fragment() {

    lateinit var model: MyViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        model = ViewModelProviders.of(activity!!).get(MyViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_q5, container, false)

        if(model!!.getNumAnswers() >= 5){
            if(model!!.highlightAns[20]){
                view!!.findViewById<Button>(R.id.strAgree_button5).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[21]){
                view!!.findViewById<Button>(R.id.agree_button5).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[22]){
                view!!.findViewById<Button>(R.id.neutral_button5).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[23]){
                view!!.findViewById<Button>(R.id.dislike_button5).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[24]){
                view!!.findViewById<Button>(R.id.strDislike_button5).setBackgroundColor(Color.rgb(157,143,247))
            }
        }

        view!!.findViewById<Button>(R.id.home5).setOnClickListener{
            view!!.findNavController().navigate(R.id.action_q5_to_home)
        }

        view!!.findViewById<Button>(R.id.prev_button5).setOnClickListener{
            view!!.findNavController().navigate(R.id.action_q5_to_q4)
        }

        view!!.findViewById<Button>(R.id.next_button5).setOnClickListener{
            if ( model!!.answers.value!!.numAnswers >= 5) { //make toast if not 1
                view!!.findNavController().navigate(R.id.action_q5_to_q6)
            }
            else {//make toast if not 2
                Toast.makeText(activity as MainActivity, "Please answer the question before moving on!", Toast.LENGTH_LONG).show()

            }
        }

        view!!.findViewById<Button>(R.id.strAgree_button5).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 5) {
                model!!.answers.value!!.numAnswers = 5
            }
            resetButtons(view)
            setHighlight(1)
            view!!.findViewById<Button>(R.id.strAgree_button5).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.agree_button5).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 5) {
                model!!.answers.value!!.numAnswers = 5
            }
            resetButtons(view)
            setHighlight(2)
            view!!.findViewById<Button>(R.id.agree_button5).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.neutral_button5).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 5) {
                model!!.answers.value!!.numAnswers = 5
            }
            resetButtons(view)
            setHighlight(3)
            view!!.findViewById<Button>(R.id.neutral_button5).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.dislike_button5).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 5) {
                model!!.answers.value!!.numAnswers = 5
            }
            resetButtons(view)
            setHighlight(4)
            view!!.findViewById<Button>(R.id.dislike_button5).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.strDislike_button5).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 5) {
                model!!.answers.value!!.numAnswers = 5
            }
            resetButtons(view)
            setHighlight(5)
            view!!.findViewById<Button>(R.id.strDislike_button5).setBackgroundColor(Color.rgb(157,143,247))
        }
        return view
    }


    private fun resetButtons(view: View){
        view.findViewById<Button>(R.id.strAgree_button5).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.agree_button5).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.neutral_button5).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.dislike_button5).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.strDislike_button5).setBackgroundColor(Color.LTGRAY)
    }

    private fun setHighlight(num: Int){

        if(num == 1){
            model!!.highlightAns[20] = true
            model!!.highlightAns[21] = false
            model!!.highlightAns[22] = false
            model!!.highlightAns[23] = false
            model!!.highlightAns[24] = false
        }
        else if(num == 2){
            model!!.highlightAns[20] = false
            model!!.highlightAns[21] = true
            model!!.highlightAns[22] = false
            model!!.highlightAns[23] = false
            model!!.highlightAns[24] = false
        }
        else if(num == 3){
            model!!.highlightAns[20] = false
            model!!.highlightAns[21] = false
            model!!.highlightAns[22] = true
            model!!.highlightAns[23] = false
            model!!.highlightAns[24] = false
        }
        else if(num == 4){
            model!!.highlightAns[20] = false
            model!!.highlightAns[21] = false
            model!!.highlightAns[22] = false
            model!!.highlightAns[23] = true
            model!!.highlightAns[24] = false
        }
        else if(num == 5){
            model!!.highlightAns[20] = false
            model!!.highlightAns[21] = false
            model!!.highlightAns[22] = false
            model!!.highlightAns[23] = false
            model!!.highlightAns[24] = true
        }
    }



}