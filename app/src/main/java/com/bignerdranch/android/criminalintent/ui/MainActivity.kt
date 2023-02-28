package com.bignerdranch.android.criminalintent.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bignerdranch.android.criminalintent.CrimeListFragment
import com.bignerdranch.android.criminalintent.R
import com.bignerdranch.android.criminalintent.controller.CrimeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.container)

        if (currentFragment == null) {
            val fragment = CrimeListFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, fragment).commit()
        }
    }
}