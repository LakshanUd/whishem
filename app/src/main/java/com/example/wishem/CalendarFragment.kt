package com.example.wishem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.*

class CalendarFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_calendar, container, false)


        val textDate: TextView = view.findViewById(R.id.textDate)


        val currentDate = SimpleDateFormat("dd MMMM", Locale.getDefault()).format(Date())
        val txt = "Today - "

        textDate.text = txt + currentDate

        return view
    }
}
