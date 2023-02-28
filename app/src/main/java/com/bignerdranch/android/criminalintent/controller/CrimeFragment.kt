package com.bignerdranch.android.criminalintent.controller

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.bignerdranch.android.criminalintent.R
import com.bignerdranch.android.criminalintent.model.Crime

class CrimeFragment : Fragment() {

    private lateinit var crime: Crime
    private lateinit var titleField: EditText
    private lateinit var dateButton: Button
    private lateinit var solvedCheckBox: CheckBox


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_crime, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        crime = Crime()
    }

    override fun onStart() {
        super.onStart()
        val titleWatcher = object : TextWatcher{
            override fun beforeTextChanged(sequence: CharSequence?, start: Int, count: Int, after: Int) { //Это пространство оставлено пустым специально
            }
            override fun onTextChanged(sequence: CharSequence?, start: Int, before: Int, count: Int) {
        crime.title = sequence.toString()                                                                 // Ввод пользователя задания заголовка
            }
            override fun afterTextChanged(sequence: Editable?) {                                          //Это пространство оставлено пустым специально
            }
        }
        solvedCheckBox.apply {
            setOnCheckedChangeListener{
                _,isChecked->crime.isSolved  = isChecked
            }
        }
    }

    private fun initView(view: View){
        titleField = view.findViewById(R.id.crime_title) as EditText
        dateButton = view.findViewById(R.id.crime_date) as Button
        dateButton.apply {
            text = crime.date.toString()
            isEnabled = false
        }
        solvedCheckBox = view.findViewById(R.id.crime_solved) as CheckBox
    }



}