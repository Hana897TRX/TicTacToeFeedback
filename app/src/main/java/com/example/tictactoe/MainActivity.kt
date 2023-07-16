package com.example.tictactoe

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var a0: Button
    private lateinit var a1: Button
    private lateinit var a2: Button
    private lateinit var a3: Button
    private lateinit var a4: Button
    private lateinit var a5: Button
    private lateinit var a6: Button
    private lateinit var a7: Button
    private lateinit var a8: Button

    val player1 = 0
    val player2 = 1
    var activePlayer = player1
    lateinit var filledPosition: IntArray



    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        filledPosition = intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1)

        a0 = findViewById(R.id.a0)
        a1 = findViewById(R.id.a1)
        a2 = findViewById(R.id.a2)
        a3 = findViewById(R.id.a3)
        a4 = findViewById(R.id.a4)
        a5 = findViewById(R.id.a5)
        a6 = findViewById(R.id.a6)
        a7 = findViewById(R.id.a7)
        a8 = findViewById(R.id.a8)

        a0.setOnClickListener(this)
        a1.setOnClickListener(this)
        a2.setOnClickListener(this)
        a3.setOnClickListener(this)
        a4.setOnClickListener(this)
        a5.setOnClickListener(this)
        a6.setOnClickListener(this)
        a7.setOnClickListener(this)
        a8.setOnClickListener(this)

        }

    override fun onClick(p0: View?) {
        var btnClicked = findViewById<Button>(p0!!.id)
        var clickedTag = Integer.parseInt(btnClicked.tag.toString())

        if (filledPosition[clickedTag]!=-1)
            return

        filledPosition[clickedTag] = activePlayer

        if(activePlayer == player1) {
            btnClicked.text = "O"
            activePlayer = player2
        } else{
            btnClicked.text= "X"
            activePlayer = player1
        }
    }
}

