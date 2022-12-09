package com.githhub.haydn0230

import java.io.File

data class Round(
    val opponentOne: String,
    val opponentTwo: String
)

private const val winPoints = 6
private const val drewPoints = 3
private const val lostPoints = 0

/* key:
    A, X = rock
    B, Y = paper
    C, Z = scissors

 Rules contains a map of what key beats what key
 */
private val lost = mapOf(
    "A" to "Y",
    "B" to "Z",
    "C" to "X"
)

private val drew = mapOf(
    "A" to "X",
    "B" to "Y",
    "C" to "Z"
)

private val win = mapOf(
    "A" to "Z",
    "B" to "X",
    "C" to "Y"
)

fun main(args: Array<String>) {
    val fileName = System.getenv("DATA_FILE")
    val currentPath = System.getenv("DIRECTORY")
    val points = File("$currentPath/$fileName")
        .readLines()
        .sumOf { line ->
            line.split(" ")
                .createRound()
                .playRockPaperScissors()
        }

    println("Total number of points are $points")
}

fun Round.playRockPaperScissors() =
    if (lost[this.opponentOne]?.contains(this.opponentTwo) == true) {
        score(this.opponentTwo) + winPoints
    } else if (drew[this.opponentOne]?.contains(this.opponentTwo) == true) {
        score(this.opponentTwo) + drewPoints
    } else {
        score(this.opponentTwo) + lostPoints
    }

private fun score(move: String) = when (move) {
    "A", "X" -> 1
    "B", "Y" -> 2
    "C", "Z" -> 3
    else -> 0
}

private fun List<String>.createRound() = Round(opponentOne = this.first(), opponentTwo = this.last())
