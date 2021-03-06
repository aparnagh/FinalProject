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
class Q6 : Fragment() {

    lateinit var model: MyViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        model = ViewModelProviders.of(activity!!).get(MyViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_q6, container, false)

        if(model!!.getNumAnswers() >= 6){
            if(model!!.highlightAns[25]){
                view!!.findViewById<Button>(R.id.strAgree_button6).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[26]){
                view!!.findViewById<Button>(R.id.agree_button6).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[27]){
                view!!.findViewById<Button>(R.id.neutral_button6).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[28]){
                view!!.findViewById<Button>(R.id.dislike_button6).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[29]){
                view!!.findViewById<Button>(R.id.strDislike_button6).setBackgroundColor(Color.rgb(157,143,247))
            }
        }

        view!!.findViewById<Button>(R.id.home6).setOnClickListener{
            view!!.findNavController().navigate(R.id.action_q6_to_home)
        }

        view!!.findViewById<Button>(R.id.prev_button6).setOnClickListener{
            view!!.findNavController().navigate(R.id.action_q6_to_q5)
        }

        view!!.findViewById<Button>(R.id.next_button6).setOnClickListener{
            if ( model!!.answers.value!!.numAnswers >= 6) { //make toast if not 1
                view!!.findNavController().navigate(R.id.action_q6_to_q7)
            }
            else {//make toast if not 2
                Toast.makeText(activity as MainActivity, "Please answer the question before moving on!", Toast.LENGTH_LONG).show()

            }
        }

        view!!.findViewById<Button>(R.id.strAgree_button6).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 6) {
                model!!.answers.value!!.numAnswers = 6
            }
            resetButtons(view)
            setHighlight(1)
            view!!.findViewById<Button>(R.id.strAgree_button6).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.agree_button6).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 6) {
                model!!.answers.value!!.numAnswers = 6
            }
            resetButtons(view)
            setHighlight(2)
            view!!.findViewById<Button>(R.id.agree_button6).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.neutral_button6).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 6) {
                model!!.answers.value!!.numAnswers = 6
            }
            resetButtons(view)
            setHighlight(3)
            view!!.findViewById<Button>(R.id.neutral_button6).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.dislike_button6).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 6) {
                model!!.answers.value!!.numAnswers = 6
            }
            resetButtons(view)
            setHighlight(4)
            view!!.findViewById<Button>(R.id.dislike_button6).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.strDislike_button6).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 6) {
                model!!.answers.value!!.numAnswers = 6
            }
            resetButtons(view)
            setHighlight(5)
            view!!.findViewById<Button>(R.id.strDislike_button6).setBackgroundColor(Color.rgb(157,143,247))
        }
        return view
    }


    private fun resetButtons(view: View){
        view.findViewById<Button>(R.id.strAgree_button6).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.agree_button6).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.neutral_button6).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.dislike_button6).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.strDislike_button6).setBackgroundColor(Color.LTGRAY)
    }

    private fun setHighlight(num: Int){

        if(num == 1){
            model!!.highlightAns[25] = true
            model!!.highlightAns[26] = false
            model!!.highlightAns[27] = false
            model!!.highlightAns[28] = false
            model!!.highlightAns[29] = false
        }
        else if(num == 2){
            model!!.highlightAns[25] = false
            model!!.highlightAns[26] = true
            model!!.highlightAns[27] = false
            model!!.highlightAns[28] = false
            model!!.highlightAns[29] = false
        }
        else if(num == 3){
            model!!.highlightAns[25] = false
            model!!.highlightAns[26] = false
            model!!.highlightAns[27] = true
            model!!.highlightAns[28] = false
            model!!.highlightAns[29] = false
        }
        else if(num == 4){
            model!!.highlightAns[25] = false
            model!!.highlightAns[26] = false
            model!!.highlightAns[27] = false
            model!!.highlightAns[28] = true
            model!!.highlightAns[29] = false
        }
        else if(num == 5){
            model!!.highlightAns[25] = false
            model!!.highlightAns[26] = false
            model!!.highlightAns[27] = false
            model!!.highlightAns[28] = false
            model!!.highlightAns[29] = true
        }
    }

}
