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
class Q10 : Fragment() {

    lateinit var model: MyViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        model = ViewModelProviders.of(activity!!).get(MyViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_q10, container, false)

        if(model!!.getNumAnswers() >= 10){
            if(model!!.highlightAns[45]){
                view!!.findViewById<Button>(R.id.strAgree_button10).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[46]){
                view!!.findViewById<Button>(R.id.agree_button10).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[47]){
                view!!.findViewById<Button>(R.id.neutral_button10).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[48]){
                view!!.findViewById<Button>(R.id.dislike_button10).setBackgroundColor(Color.rgb(157,143,247))
            }
            else if(model!!.highlightAns[49]){
                view!!.findViewById<Button>(R.id.strDislike_button10).setBackgroundColor(Color.rgb(157,143,247))
            }
        }

        view!!.findViewById<Button>(R.id.home10).setOnClickListener{
            view!!.findNavController().navigate(R.id.action_q10_to_home)
        }

        view!!.findViewById<Button>(R.id.prev_button10).setOnClickListener{
            view!!.findNavController().navigate(R.id.action_q10_to_q9)
        }

        view!!.findViewById<Button>(R.id.next_button10).setOnClickListener{
            if ( model!!.answers.value!!.numAnswers >= 10) { //make toast if not 1
                view!!.findNavController().navigate(R.id.action_q10_to_q11)
            }
            else {//make toast if not 2
                Toast.makeText(activity as MainActivity, "Please answer the question before moving on!", Toast.LENGTH_LONG).show()
            }
        }

        view!!.findViewById<Button>(R.id.strAgree_button10).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 10) {
                model!!.answers.value!!.numAnswers = 10
            }
            resetButtons(view)
            setHighlight(1)
            view!!.findViewById<Button>(R.id.strAgree_button10).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.agree_button10).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 10) {
                model!!.answers.value!!.numAnswers = 10
            }
            resetButtons(view)
            setHighlight(2)
            view!!.findViewById<Button>(R.id.agree_button10).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.neutral_button10).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 10) {
                model!!.answers.value!!.numAnswers = 10
            }
            resetButtons(view)
            setHighlight(3)
            view!!.findViewById<Button>(R.id.neutral_button10).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.dislike_button10).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 10) {
                model!!.answers.value!!.numAnswers = 10
            }
            resetButtons(view)
            setHighlight(4)
            view!!.findViewById<Button>(R.id.dislike_button10).setBackgroundColor(Color.rgb(157,143,247))
        }

        view!!.findViewById<Button>(R.id.strDislike_button10).setOnClickListener{
if(model!!.answers.value!!.numAnswers < 10) {
                model!!.answers.value!!.numAnswers = 10
            }
            resetButtons(view)
            setHighlight(5)
            view!!.findViewById<Button>(R.id.strDislike_button10).setBackgroundColor(Color.rgb(157,143,247))
        }
        return view
    }


    private fun resetButtons(view: View){
        view.findViewById<Button>(R.id.strAgree_button10).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.agree_button10).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.neutral_button10).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.dislike_button10).setBackgroundColor(Color.LTGRAY)
        view.findViewById<Button>(R.id.strDislike_button10).setBackgroundColor(Color.LTGRAY)
    }

    private fun setHighlight(num: Int){

        if(num == 1){
            model!!.highlightAns[45] = true
            model!!.highlightAns[46] = false
            model!!.highlightAns[47] = false
            model!!.highlightAns[48] = false
            model!!.highlightAns[49] = false
        }
        else if(num == 2){
            model!!.highlightAns[45] = false
            model!!.highlightAns[46] = true
            model!!.highlightAns[47] = false
            model!!.highlightAns[48] = false
            model!!.highlightAns[49] = false
        }
        else if(num == 3){
            model!!.highlightAns[45] = false
            model!!.highlightAns[46] = false
            model!!.highlightAns[47] = true
            model!!.highlightAns[48] = false
            model!!.highlightAns[49] = false
        }
        else if(num == 4){
            model!!.highlightAns[45] = false
            model!!.highlightAns[46] = false
            model!!.highlightAns[47] = false
            model!!.highlightAns[48] = true
            model!!.highlightAns[49] = false
        }
        else if(num == 5){
            model!!.highlightAns[45] = false
            model!!.highlightAns[46] = false
            model!!.highlightAns[47] = false
            model!!.highlightAns[48] = false
            model!!.highlightAns[49] = true
        }
    }


}
