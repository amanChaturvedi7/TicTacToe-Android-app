package com.example.asus.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlin.system.exitProcess
import android.content.Intent



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun bClick(view: View){
        val bSelected = view as Button
        var cellId = 0
        when(bSelected.id){
            R.id.b1 -> cellId = 1
            R.id.b2 -> cellId = 2
            R.id.b3 -> cellId = 3
            R.id.b4 -> cellId = 4
            R.id.b5 -> cellId = 5
            R.id.b6 -> cellId = 6
            R.id.b7 -> cellId = 7
            R.id.b8 -> cellId = 8
            R.id.b9 -> cellId = 9
        }
        //Toast.makeText(this, "cell ID: $cellId", Toast.LENGTH_LONG).show()
        playGame(cellId, bSelected)
    }
    var player1 = arrayListOf<Int>()
    var player2 = arrayListOf<Int>()

    var activePlayer = 1

    private fun playGame(cellId: Int, bSelected: Button){
        if(activePlayer==1){
            bSelected.setText("X")
            player1.add(cellId)
            bSelected.setBackgroundColor(Color.BLUE)
            activePlayer=2
        }else{
            bSelected.setText("O")
            player2.add(cellId)
            bSelected.setBackgroundColor(Color.GREEN)
            activePlayer=1
        }
        bSelected.isEnabled = false
        winner()
    }

    private fun winner(){
        var winner = 0
        //rows
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }
        //cols
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }
        //diag
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2
        }
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner = 2
        }

        var n = arrayListOf<Int>()
        n.addAll(player1)
        n.addAll(player2)
        n.sort()
        var m = arrayListOf<Int>(1,2,3,4,5,6,7,8,9)

        if(winner!=0){
            Toast.makeText(this, "Winner is Player$winner", Toast.LENGTH_LONG).show()
            val i = baseContext.packageManager
                    .getLaunchIntentForPackage(baseContext.packageName)
            i!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(i)
        }
        if(n.equals(m)){
            Toast.makeText(this, "It's a Draw !", Toast.LENGTH_LONG).show()
            val i = baseContext.packageManager
                    .getLaunchIntentForPackage(baseContext.packageName)
            i!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(i)
        }

    }
}
