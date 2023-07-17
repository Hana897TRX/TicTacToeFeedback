package com.example.tictactoe

import android.annotation.SuppressLint
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

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
    private lateinit var tv: TextView

    private val player1 = 0
    private val player2 = 1
    private var activePlayer = player1
    lateinit var filledPos: IntArray

    var gameActive = true



    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        filledPos = intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1)

        tv = findViewById(R.id.textView3)
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

        if(!gameActive)
            return

        var btnClicked = findViewById<Button>(p0!!.id)
        var clickedTag = Integer.parseInt(btnClicked.tag.toString())

        if (filledPos[clickedTag]!=-1)
            return

        filledPos[clickedTag] = activePlayer

        if(activePlayer == player1) {
            btnClicked.text = "O"
            activePlayer = player2
            tv.text = "Player 2 Turn"
        } else{
            btnClicked.text= "X"
            activePlayer = player1
            tv.text = "Player 1 Turn"
        }

        checkForWin()
    }

    private fun checkForWin() {
        var winPos = arrayOf(
            intArrayOf(0,1,2),
            intArrayOf(3,4,5),
            intArrayOf(6,7,8),
            intArrayOf(0,3,6),
            intArrayOf(1,4,7),
            intArrayOf(2,5,8),
            intArrayOf(0,4,8),
            intArrayOf(2,4,6),
        )

        for (i in 0 until winPos.size) {
            var val0 = winPos [i][0]
            var val1 = winPos [i][1]
            var val2 = winPos [i][2]

            if(filledPos[val0]==filledPos[val1] && filledPos[val1]==filledPos[val2]){
                if(filledPos[val0]!=-1) {
                    gameActive = false
                    if (filledPos[val0]== player1) {
                        showMessage("Player 1 Wins")
                        //tv.text=("Player 1 Wins")
                    } else {
                        //tv.text=("Player 2 Wins")
                        showMessage("Player 2 Wins")
                    }
                }
            }
        }

    }

    private fun showMessage(s: String) {
        AlertDialog.Builder(this)
            .setMessage(s)
            .setTitle("Tic Tac Toe")
            .setPositiveButton("Restart Game", DialogInterface.OnClickListener { dialogInterface, i ->
                restartGame()
            })
            .show()


    }

    private fun restartGame() {
        filledPos = intArrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1)
        activePlayer = player1
        gameActive = true
        tv.text=("Player 1 Turn")
        a0.text=("")
        a1.text=("")
        a2.text=("")
        a3.text=("")
        a4.text=("")
        a5.text=("")
        a6.text=("")
        a7.text=("")
        a8.text=("")
    }
}

