package com.example.tiktakto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.tiktakto.R.id.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun bClick(view: View) {

        val bSelected = view as Button

        var cellID = 0

        when(bSelected.id){
            b1 -> cellID = 1
            b2 -> cellID = 2
            b3 -> cellID = 3
            b4 -> cellID = 4
            b5 -> cellID = 5
            b6 -> cellID = 6
            b7 -> cellID = 7
            b8 -> cellID = 8
            b9 -> cellID = 9
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
            autoPlay()
        }else{
            bSelected.text = "O"
            bSelected.setBackgroundResource(R.color.blue)
            playerTwo.add(cellId)
            activePlayer = 1
        }
        bSelected.isEnabled = false

        checkWinner()
    }

     fun autoPlay() {

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