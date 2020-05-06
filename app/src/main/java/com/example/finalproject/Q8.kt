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
class Q8 : Fragment() {

    lateinit var model: MyViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        model = ViewModelProviders.of(activity!!).get(MyViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_q8, container, false)

        if(model!!.getNumAnswers() >= 8){
            if(model!!.highlightAns[35]){
                view!!.findViewById<Button>(R.id.strAgree_button8).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[36]){
                view!!.findViewById<Button>(R.id.agree_button8).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[37]){
                view!!.findViewById<Button>(R.id.neutral_button8).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[38]){
                view!!.findViewById<Button>(R.id.dislike_button8).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[39]){
                view!!.findViewById<Button>(R.id.strDislike_button8).setBackgroundColor(Color.rgb(157,143,247))
            }
        }

        view!!.findViewById<Button>(R.id.home8).setOnClickListener{
            view!!.findNavController().navigate(R.id.action_q8_to_home)
        }

        view!!.findViewById<Button>(R.id.prev_button8).setOnClickListener{
            view!!.findNavController().navigate(R.id.action_q8_to_q7)
        }

        view!!.findViewById<Button>(R.id.next_button8).setOnClickListener{
            if ( model!!.answers.value!!.numAnswers >= 8) { //make toast if not 1
                view!!.findNavController().navigate(R.id.action_q8_to_q9)
            }
            else {//make toast if not 2
                Toast.makeText(activity as MainActivity, "Please answer the question before moving on!", Toast.LENGTH_LONG).show()

            }
        }

        view!!.findViewById<Button>(R.id.strAgree_button8).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 8) {
                model!!.answers.value!!.numAnswers = 8
            }
            resetButtons(view)
            setHighlight(1)
            view!!.findViewById<Button>(R.id.strAgree_button8).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.agree_button8).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 8) {
                model!!.answers.value!!.numAnswers = 8
            }
            resetButtons(view)
            setHighlight(2)
            view!!.findViewById<Button>(R.id.agree_button8).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.neutral_button8).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 8) {
                model!!.answers.value!!.numAnswers = 8
            }
            resetButtons(view)
            setHighlight(3)
            view!!.findViewById<Button>(R.id.neutral_button8).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.dislike_button8).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 8) {
                model!!.answers.value!!.numAnswers = 8
            }
            resetButtons(view)
            setHighlight(4)
            view!!.findViewById<Button>(R.id.dislike_button8).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.strDislike_button8).setOnClickListener{
            if(model!!.answers.value!!.numAnswers < 8) {
                model!!.answers.value!!.numAnswers = 8
            }
            resetButtons(view)
            setHighlight(5)
            view!!.findViewById<Button>(R.id.strDislike_button8).setBackgroundColor(Color.rgb(157,143,247))
        }

        return view
    }


    private fun resetButtons(view: View){
        view.findViewById<Button>(R.id.strAgree_button8).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.agree_button8).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.neutral_button8).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.dislike_button8).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.strDislike_button8).setBackgroundColor(Color.LTGRAY)
    }


    private fun setHighlight(num: Int){

        if(num == 1){
            model!!.highlightAns[35] = true
            model!!.highlightAns[36] = false
            model!!.highlightAns[37] = false
            model!!.highlightAns[38] = false
            model!!.highlightAns[39] = false
        }
        else if(num == 2){
            model!!.highlightAns[35] = false
            model!!.highlightAns[36] = true
            model!!.highlightAns[37] = false
            model!!.highlightAns[38] = false
            model!!.highlightAns[39] = false
        }
        else if(num == 3){
            model!!.highlightAns[35] = false
            model!!.highlightAns[36] = false
            model!!.highlightAns[37] = true
            model!!.highlightAns[38] = false
            model!!.highlightAns[39] = false
        }
        else if(num == 4){
            model!!.highlightAns[35] = false
            model!!.highlightAns[36] = false
            model!!.highlightAns[37] = false
            model!!.highlightAns[38] = true
            model!!.highlightAns[39] = false
        }
        else if(num == 5){
            model!!.highlightAns[35] = false
            model!!.highlightAns[36] = false
            model!!.highlightAns[37] = false
            model!!.highlightAns[38] = false
            model!!.highlightAns[39] = true
        }
    }

}
