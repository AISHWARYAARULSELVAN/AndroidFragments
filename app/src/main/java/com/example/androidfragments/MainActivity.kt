package com.example.androidfragments

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var btnBasic: Button
    private lateinit var btnMarks: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBasic = findViewById(R.id.btnBasic)
        btnMarks = findViewById(R.id.btnMarks)

        // Load default fragment on first creation
        if (savedInstanceState == null) {
            loadFragment(BasicDetailsFragment())
        }

        btnBasic.setOnClickListener {
            loadFragment(BasicDetailsFragment())
        }

        btnMarks.setOnClickListener {
            loadFragment(MarksFragment())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
