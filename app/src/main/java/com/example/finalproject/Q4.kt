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
class Q4 : Fragment() {

    lateinit var model: MyViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        model = ViewModelProviders.of(activity!!).get(MyViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_q4, container, false)

        if(model!!.getNumAnswers() >= 4){
            if(model!!.highlightAns[15]){
                view!!.findViewById<Button>(R.id.strAgree_button4).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[16]){
                view!!.findViewById<Button>(R.id.agree_button4).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[17]){
                view!!.findViewById<Button>(R.id.neutral_button4).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[18]){
                view!!.findViewById<Button>(R.id.dislike_button4).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[19]){
                view!!.findViewById<Button>(R.id.strDislike_button4).setBackgroundColor(Color.rgb(157,143,247))
            }
        }

        view!!.findViewById<Button>(R.id.home4).setOnClickListener{
            view!!.findNavController().navigate(R.id.action_q4_to_home)
        }

        view!!.findViewById<Button>(R.id.prev_button4).setOnClickListener{
            view!!.findNavController().navigate(R.id.action_q4_to_q3)
        }

        view!!.findViewById<Button>(R.id.next_button4).setOnClickListener{
            if ( model!!.answers.value!!.numAnswers >= 4) { //make toast if not 1
                view!!.findNavController().navigate(R.id.action_q4_to_q5)
            }
            else {//make toast if not 2
                Toast.makeText(activity as MainActivity, "Please answer the question before moving on!", Toast.LENGTH_LONG).show()

            }
        }

        view!!.findViewById<Button>(R.id.strAgree_button4).setOnClickListener{
            if(model!!.answers.value!!.numAnswers < 4) {
                model!!.answers.value!!.numAnswers = 4
            }
            resetButtons(view)
            setHighlight(1)
            view!!.findViewById<Button>(R.id.strAgree_button4).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.agree_button4).setOnClickListener{
            if(model!!.answers.value!!.numAnswers < 4) {
                model!!.answers.value!!.numAnswers = 4
            }
            resetButtons(view)
            setHighlight(2)
            view!!.findViewById<Button>(R.id.agree_button4).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.neutral_button4).setOnClickListener{
        if(model!!.answers.value!!.numAnswers < 4) {
                model!!.answers.value!!.numAnswers = 4
            }
            resetButtons(view)
            setHighlight(3)
            view!!.findViewById<Button>(R.id.neutral_button4).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.dislike_button4).setOnClickListener{
            if(model!!.answers.value!!.numAnswers < 4) {
                model!!.answers.value!!.numAnswers = 4
            }
            resetButtons(view)
            setHighlight(4)
            view!!.findViewById<Button>(R.id.dislike_button4).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.strDislike_button4).setOnClickListener{
            if(model!!.answers.value!!.numAnswers < 4) {
                model!!.answers.value!!.numAnswers = 4
            }
            resetButtons(view)
            setHighlight(5)
            view!!.findViewById<Button>(R.id.strDislike_button4).setBackgroundColor(Color.rgb(157,143,247))
        }

        return view
    }


    private fun resetButtons(view: View){
        view.findViewById<Button>(R.id.strAgree_button4).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.agree_button4).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.neutral_button4).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.dislike_button4).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.strDislike_button4).setBackgroundColor(Color.LTGRAY)
    }

    private fun setHighlight(num: Int){

        if(num == 1){
            model!!.highlightAns[15] = true
            model!!.highlightAns[16] = false
            model!!.highlightAns[17] = false
            model!!.highlightAns[18] = false
            model!!.highlightAns[19] = false
        }
        else if(num == 2){
            model!!.highlightAns[15] = false
            model!!.highlightAns[16] = true
            model!!.highlightAns[17] = false
            model!!.highlightAns[18] = false
            model!!.highlightAns[19] = false
        }
        else if(num == 3){
            model!!.highlightAns[15] = false
            model!!.highlightAns[16] = false
            model!!.highlightAns[17] = true
            model!!.highlightAns[18] = false
            model!!.highlightAns[19] = false
        }
        else if(num == 4){
            model!!.highlightAns[15] = false
            model!!.highlightAns[16] = false
            model!!.highlightAns[17] = false
            model!!.highlightAns[18] = true
            model!!.highlightAns[19] = false
        }
        else if(num == 5){
            model!!.highlightAns[10] = false
            model!!.highlightAns[11] = false
            model!!.highlightAns[12] = false
            model!!.highlightAns[13] = false
            model!!.highlightAns[14] = true
        }
    }



}
