package com.example.finalproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.recyclerviewcard.*
import java.lang.Math.round
import kotlin.math.roundToInt
import kotlin.math.roundToLong

/**
 * A simple [Fragment] subclass.
 */
class analytics : Fragment() {

    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        database = Firebase.database.reference
        val view = inflater.inflate(R.layout.fragment_analytics, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv)
        val adapter = SurveyListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity as MainActivity)


        database.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                val items: ArrayList<SurveyResult> = ArrayList<SurveyResult>()
                for (postSnapshot in dataSnapshot.getChildren()) {
                    var data = postSnapshot.getValue(SurveyResult::class.java)
                    items.add(data!!)

                }

                adapter.setSurvey(items)
            }

        })


        return view

    }

    inner class SurveyListAdapter() :
        RecyclerView.Adapter<SurveyListAdapter.SurveyViewHolder>() {
        private var surveys = emptyList<SurveyResult>()

        internal fun setSurvey(surveys: List<SurveyResult>) {
            this.surveys = surveys
            notifyDataSetChanged()
        }

        override fun getItemCount(): Int {

            return surveys.size
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurveyViewHolder {


            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerviewcard, parent, false)
            return SurveyViewHolder(v)
        }

        override fun onBindViewHolder(holder: SurveyViewHolder, position: Int) {


            holder.view.findViewById<TextView>(R.id.date).text = "Date: " + surveys[position].date
            var percentage = (surveys[position].numAnswers/12.0)*100.0


           // Log.d("percent",(surveys[position].numAnswers / 12.0).toString())
           holder.view.findViewById<TextView>(R.id.percent).text = "Percent: " + String.format("%.1f", percentage) + " %"


        }

        inner class SurveyViewHolder(val view: View) : RecyclerView.ViewHolder(view),
            View.OnClickListener {
            override fun onClick(view: View?) {

                if (view != null) {
                }
            }

        }
    }
}
