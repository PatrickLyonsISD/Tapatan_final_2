package com.mad.tapatanfinal2.ui.theme

import android.view.View
import android.widget.Button
import androidx.lifecycle.ViewModel


class GameViewModel : ViewModel() {
    var buttons = Array(3) { arrayOfNulls<String>(3) }
    var currentPlayer = "Black"
    var roundCount = 0
    var gameEnded = false

    fun onButtonClick(row: Int, col: Int) {
        if (buttons[row][col] == null && !gameEnded) {
            buttons[row][col] = currentPlayer
            roundCount++
            if (checkForWin(row, col)) {
                gameEnded = true
            } else if (roundCount == 9) {
                gameEnded = true
            } else {
                currentPlayer = if (currentPlayer == "Black") "White" else "Black"
            }
        }
    }

    private fun checkForWin(row: Int, col: Int): Boolean {
        val player = buttons[row][col]

        // Check for horizontal win
        for (i in 0 until 3) {
            if (buttons[row][i] != player) {
                break
            }
            if (i == 2) {
                return true
            }
        }

        // Check for vertical win
        for (i in 0 until 3) {
            if (buttons[i][col] != player) {
                break
            }
            if (i == 2) {
                return true
            }
        }

        // Check for diagonal win (top-left to bottom-right)
        if (row == col) {
            for (i in 0 until 3) {
                if (buttons[i][i] != player) {
                    break
                }
                if (i == 2) {
                    return true
                }
            }
        }

        // Check for diagonal win (top-right to bottom-left)
        if (row + col == 2) {
            for (i in 0 until 3) {
                if (buttons[i][2 - i] != player) {
                    break
                }
                if (i == 2) {
                    return true
                }
            }
        }

        return false
    }


    fun resetGame() {
        buttons = Array(3) { arrayOfNulls<String>(3) }
        currentPlayer = "Black"
        roundCount = 0
        gameEnded = false
    }
}
