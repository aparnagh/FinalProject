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
class Q7 : Fragment() {

    lateinit var model: MyViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        model = ViewModelProviders.of(activity!!).get(MyViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_q7, container, false)

        if(model!!.getNumAnswers() >= 7){
            if(model!!.highlightAns[30]){
                view!!.findViewById<Button>(R.id.strAgree_button7).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[31]){
                view!!.findViewById<Button>(R.id.agree_button7).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[32]){
                view!!.findViewById<Button>(R.id.neutral_button7).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[33]){
                view!!.findViewById<Button>(R.id.dislike_button7).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[34]){
                view!!.findViewById<Button>(R.id.strDislike_button7).setBackgroundColor(Color.rgb(157,143,247))
            }
        }

        view!!.findViewById<Button>(R.id.home7).setOnClickListener{
            view!!.findNavController().navigate(R.id.action_q7_to_home)
        }

        view!!.findViewById<Button>(R.id.prev_button7).setOnClickListener{
            view!!.findNavController().navigate(R.id.action_q7_to_q6)
        }

        view!!.findViewById<Button>(R.id.next_button7).setOnClickListener{
            if ( model!!.answers.value!!.numAnswers >= 7) { //make toast if not 1
                view!!.findNavController().navigate(R.id.action_q7_to_q8)
            }
            else {//make toast if not 2
                Toast.makeText(activity as MainActivity, "Please answer the question before moving on!", Toast.LENGTH_LONG).show()

            }
        }

        view!!.findViewById<Button>(R.id.strAgree_button7).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 7) {
                model!!.answers.value!!.numAnswers = 7
            }
            resetButtons(view)
            setHighlight(1)
            view!!.findViewById<Button>(R.id.strAgree_button7).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.agree_button7).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 7) {
                model!!.answers.value!!.numAnswers = 7
            }
            resetButtons(view)
            setHighlight(2)
            view!!.findViewById<Button>(R.id.agree_button7).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.neutral_button7).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 7) {
                model!!.answers.value!!.numAnswers = 7
            }
            resetButtons(view)
            setHighlight(3)
            view!!.findViewById<Button>(R.id.neutral_button7).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.dislike_button7).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 7) {
                model!!.answers.value!!.numAnswers = 7
            }
            resetButtons(view)
            setHighlight(4)
            view!!.findViewById<Button>(R.id.dislike_button7).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.strDislike_button7).setOnClickListener{
if(model!!.answers.value!!.numAnswers <7) {
                model!!.answers.value!!.numAnswers = 7
            }
            resetButtons(view)
            setHighlight(5)
            view!!.findViewById<Button>(R.id.strDislike_button7).setBackgroundColor(Color.rgb(157,143,247))
        }
        return view
    }

    private fun resetButtons(view: View){
        view.findViewById<Button>(R.id.strAgree_button7).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.agree_button7).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.neutral_button7).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.dislike_button7).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.strDislike_button7).setBackgroundColor(Color.LTGRAY)
    }

    private fun setHighlight(num: Int){

        if(num == 1){
            model!!.highlightAns[30] = true
            model!!.highlightAns[31] = false
            model!!.highlightAns[32] = false
            model!!.highlightAns[33] = false
            model!!.highlightAns[34] = false
        }
        else if(num == 2){
            model!!.highlightAns[30] = false
            model!!.highlightAns[31] = true
            model!!.highlightAns[32] = false
            model!!.highlightAns[33] = false
            model!!.highlightAns[34] = false
        }
        else if(num == 3){
            model!!.highlightAns[30] = false
            model!!.highlightAns[31] = false
            model!!.highlightAns[32] = true
            model!!.highlightAns[33] = false
            model!!.highlightAns[34] = false
        }
        else if(num == 4){
            model!!.highlightAns[30] = false
            model!!.highlightAns[31] = false
            model!!.highlightAns[32] = false
            model!!.highlightAns[33] = true
            model!!.highlightAns[34] = false
        }
        else if(num == 5){
            model!!.highlightAns[30] = false
            model!!.highlightAns[31] = false
            model!!.highlightAns[32] = false
            model!!.highlightAns[33] = false
            model!!.highlightAns[34] = true
        }
    }


}
