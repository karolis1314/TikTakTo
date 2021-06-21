package com.example.tiktakto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun bClick(view: View) {

        val bSelected = view as Button

        var cellID = 0

        when(bSelected.id){
            R.id.b1 -> cellID = 1
            R.id.b2 -> cellID = 2
            R.id.b3 -> cellID = 3
            R.id.b4 -> cellID = 4
            R.id.b5 -> cellID = 5
            R.id.b6 -> cellID = 6
            R.id.b7 -> cellID = 7
            R.id.b8 -> cellID = 8
            R.id.b9 -> cellID = 9
        }

        playGame(cellID, bSelected)
    }

    var activePlayer = 1

    var playerOne = ArrayList<Int>()
    var playerTwo = ArrayList<Int>()
    fun playGame(cellId:Int, bSelected:Button){

        if(activePlayer == 1){
            bSelected.text = "X"
            bSelected.setBackgroundResource(R.color.green)
            playerOne.add(cellId)
            activePlayer = 2
        }else{
            bSelected.text = "O"
            bSelected.setBackgroundResource(R.color.blue)
            playerTwo.add(cellId)
            activePlayer = 1
        }
        bSelected.isEnabled = false

        checkWinner()
    }

    fun checkWinner(){
        var winner = -1

        //row1

        if(playerOne.contains(1)&&playerOne.contains(2)&&playerOne.contains(2)){
            winner = 1
        }
        if(playerTwo.contains(1)&&playerTwo.contains(2)&&playerTwo.contains(2)){
            winner = 2
        }

        //row2

        if(playerOne.contains(4)&&playerOne.contains(5)&&playerOne.contains(6)){
            winner = 1
        }
        if(playerTwo.contains(4)&&playerTwo.contains(5)&&playerTwo.contains(6)){
            winner = 2
        }

        //row3

        if(playerOne.contains(7)&&playerOne.contains(8)&&playerOne.contains(9)){
            winner = 1
        }
        if(playerTwo.contains(7)&&playerTwo.contains(8)&&playerTwo.contains(9)){
            winner = 2
        }

        //col1

        if(playerOne.contains(1)&&playerOne.contains(4)&&playerOne.contains(7)){
            winner = 1
        }
        if(playerTwo.contains(1)&&playerTwo.contains(4)&&playerTwo.contains(7)){
            winner = 2
        }

        //col2

        if(playerOne.contains(2)&&playerOne.contains(5)&&playerOne.contains(8)){
            winner = 1
        }
        if(playerTwo.contains(2)&&playerTwo.contains(5)&&playerTwo.contains(8)){
            winner = 2
        }

        //col2

        if(playerOne.contains(3)&&playerOne.contains(6)&&playerOne.contains(9)){
            winner = 1
        }
        if(playerTwo.contains(3)&&playerTwo.contains(6)&&playerTwo.contains(9)){
            winner = 2
        }

        if(winner == 1){
            Toast.makeText(this, "Player one won the game!", Toast.LENGTH_LONG).show()
        }else if(winner == 2){
            Toast.makeText(this, "Player two won the game!", Toast.LENGTH_LONG).show()
        }
    }
}