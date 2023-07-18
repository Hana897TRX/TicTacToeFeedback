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

    // I think its okay this structure, but a better naming could be better, for example: btnA0, btnA1, etc.
    // In Android we use a naming like:
    // Button: btnName
    // TextView: txtName
    // ImageView: imgName
    // And so on...
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
    private lateinit var filledPos: IntArray // Keep your variables private

    private val winPos = arrayOf(
        intArrayOf(0,1,2),
        intArrayOf(3,4,5),
        intArrayOf(6,7,8),
        intArrayOf(0,3,6),
        intArrayOf(1,4,7),
        intArrayOf(2,5,8),
        intArrayOf(0,4,8),
        intArrayOf(2,4,6),
    )

    private var gameActive = true // Keep your variables private



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

        // This is okay, but normally in Android we use the View.OnClickListener
        // I will write the example below and an example of it
        // a0.setOnClickListener { onClick(it) } - it refers to the view that was clicked,
        // then we can use your function onClick that is written below

        a0.setOnClickListener(this)
        a1.setOnClickListener(this)
        a2.setOnClickListener(this)
        a3.setOnClickListener(this)
        a4.setOnClickListener(this)
        a5.setOnClickListener(this)
        a6.setOnClickListener(this)
        a7.setOnClickListener(this)
        a8.setOnClickListener(this)

        // a0.setOnClickListener { onClick(it) }
        // a1.setOnClickListener { onClick(it) }
        // a2.setOnClickListener { onClick(it) }
        // a3.setOnClickListener { onClick(it) }
        // ..
    }

    override fun onClick(p0: View?) {

        if(!gameActive)
            return

        // We need to avoid using !!, this can cause a crash when we have don't pass a p0 value
        // if i use your function onClick(null) your app will crash
        val btnClicked = findViewById<Button>(p0!!.id)
        val clickedTag = Integer.parseInt(btnClicked.tag.toString())

        if (filledPos[clickedTag] != -1)
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

    // This function is okay, but we can improve it like below

    private fun onClick2(view: View?) {
        view?.let {
            if(!gameActive)
                return

            val btnClicked = findViewById<Button>(view.id) // using view?.let, I asking the view if its null, if it is the code inside the let will not be executed
            val clickedTag = Integer.parseInt(btnClicked.tag.toString())

            if (filledPos[clickedTag] != -1)
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
    }

    private fun checkForWin() {
        winPos.forEach { pos ->
            val val0 = pos[0]
            val val1 = pos[1]
            val val2 = pos[2]

            if (filledPos[val0] == filledPos[val1] && filledPos[val1] == filledPos[val2]) {
                if(filledPos[val0] !=- 1) {
                    gameActive = false
                    if (filledPos[val0] == player1) {
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
            .setPositiveButton("Restart Game", DialogInterface.OnClickListener { _, _ ->
                restartGame()
            })
            .show()
    }

    private fun restartGame() {
        filledPos = intArrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1)
        activePlayer = player1
        gameActive = true
        tv.text= "Player 1 Turn"
        a0.text= ""
        a1.text= ""
        a2.text= ""
        a3.text= ""
        a4.text= ""
        a5.text= ""
        a6.text= ""
        a7.text= ""
        a8.text= ""
    }
}


