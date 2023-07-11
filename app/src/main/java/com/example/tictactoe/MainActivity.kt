package com.example.tictactoe

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var x1y1: Button
    private lateinit var x1y2: Button
    private lateinit var x1y3: Button
    private lateinit var x2y1: Button
    private lateinit var x2y2: Button
    private lateinit var x2y3: Button
    private lateinit var x3y1: Button
    private lateinit var x3y2: Button
    private lateinit var x3y3: Button
    private var m1: Int = 0
    private var m2: Int = 0
    private var m3: Int = 0
    private var m4: Int = 0
    private var m5: Int = 0
    private var m6: Int = 0
    private var m7: Int = 0
    private var m8: Int = 0



    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        x1y1 = findViewById(R.id.x1y1)
        x1y2 = findViewById(R.id.x1y2)
        x1y3 = findViewById(R.id.x1y3)
        x2y1 = findViewById(R.id.x2y1)
        x2y2 = findViewById(R.id.x2y2)
        x2y3 = findViewById(R.id.x2y3)
        x3y1 = findViewById(R.id.x1y1)
        x3y2 = findViewById(R.id.x1y2)
        x3y3 = findViewById(R.id.x1y3)

        m1 = 0
        m2 = 0
        m3 = 0
        m4 = 0
        m5 = 0
        m6 = 0
        m7 = 0
        m8 = 0



        }

    private fun onButtonClick(view: View) {
        val p1Move = 1
        m1.plus(p1Move)
    }
}

