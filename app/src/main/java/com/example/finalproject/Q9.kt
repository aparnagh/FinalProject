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
class Q9 : Fragment() {

    lateinit var model: MyViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        model = ViewModelProviders.of(activity!!).get(MyViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_q9, container, false)

        if(model!!.getNumAnswers() >= 9){
            if(model!!.highlightAns[40]){
                view!!.findViewById<Button>(R.id.strAgree_button9).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[41]){
                view!!.findViewById<Button>(R.id.agree_button9).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[42]){
                view!!.findViewById<Button>(R.id.neutral_button9).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[43]){
                view!!.findViewById<Button>(R.id.dislike_button9).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[44]){
                view!!.findViewById<Button>(R.id.strDislike_button9).setBackgroundColor(Color.rgb(157,143,247))
            }
        }

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
            resetButtons(view)
            setHighlight(1)
            view!!.findViewById<Button>(R.id.strAgree_button9).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.agree_button9).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 9) {
                model!!.answers.value!!.numAnswers = 9
            }
            resetButtons(view)
            setHighlight(2)
            view!!.findViewById<Button>(R.id.agree_button9).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.neutral_button9).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 9) {
                model!!.answers.value!!.numAnswers = 9
            }
            resetButtons(view)
            setHighlight(3)
            view!!.findViewById<Button>(R.id.neutral_button9).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.dislike_button9).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 9) {
                model!!.answers.value!!.numAnswers = 9
            }
            resetButtons(view)
            setHighlight(4)
            view!!.findViewById<Button>(R.id.dislike_button9).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.strDislike_button9).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 9) {
                model!!.answers.value!!.numAnswers = 9
            }
            resetButtons(view)
            setHighlight(5)
            view!!.findViewById<Button>(R.id.strDislike_button9).setBackgroundColor(Color.rgb(157,143,247))
        }
        return view
    }


    private fun resetButtons(view: View){
        view.findViewById<Button>(R.id.strAgree_button9).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.agree_button9).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.neutral_button9).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.dislike_button9).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.strDislike_button9).setBackgroundColor(Color.LTGRAY)
    }


    private fun setHighlight(num: Int){

        if(num == 1){
            model!!.highlightAns[40] = true
            model!!.highlightAns[41] = false
            model!!.highlightAns[42] = false
            model!!.highlightAns[43] = false
            model!!.highlightAns[44] = false
        }
        else if(num == 2){
            model!!.highlightAns[40] = false
            model!!.highlightAns[41] = true
            model!!.highlightAns[42] = false
            model!!.highlightAns[43] = false
            model!!.highlightAns[44] = false
        }
        else if(num == 3){
            model!!.highlightAns[40] = false
            model!!.highlightAns[41] = false
            model!!.highlightAns[42] = true
            model!!.highlightAns[43] = false
            model!!.highlightAns[44] = false
        }
        else if(num == 4){
            model!!.highlightAns[40] = false
            model!!.highlightAns[41] = false
            model!!.highlightAns[42] = false
            model!!.highlightAns[43] = true
            model!!.highlightAns[44] = false
        }
        else if(num == 5){
            model!!.highlightAns[40] = false
            model!!.highlightAns[41] = false
            model!!.highlightAns[42] = false
            model!!.highlightAns[43] = false
            model!!.highlightAns[44] = true
        }
    }

}
