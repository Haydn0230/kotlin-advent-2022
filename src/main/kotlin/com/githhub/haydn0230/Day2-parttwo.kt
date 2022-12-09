package com.githhub.haydn0230

import java.io.File


data class FixedRound(
    val opponentsMove: String,
    val outcome: String
)


private const val winPoints = 6
private const val drewPoints = 3
private const val lostPoints = 0

private val win = mapOf(
    "A" to "B",
    "B" to "C",
    "C" to "A"
)

private val lost = mapOf(
    "A" to "C",
    "B" to "A",
    "C" to "B"
)
/* key:
    A = rock
    B = paper
    C = scissors

    X = lose
    Y = draw
    Z = win

 */
fun main(args: Array<String>) {
    val fileName = System.getenv("DATA_FILE")
    val currentPath = System.getenv("DIRECTORY")
    val points = File("$currentPath/$fileName")
        .readLines()
        .sumOf { line ->
            line.split(" ")
                .createFixedRound()
                .playRockPaperScissors()
        }

    println("Total number of points are $points")
}

fun FixedRound.playRockPaperScissors() = when (this.outcome) {
    "X" -> fixScore(lost[this.opponentsMove] ?: "") + lostPoints
    "Y" -> fixScore(this.opponentsMove) + drewPoints
    "Z" -> fixScore(win[this.opponentsMove] ?: "") + winPoints
    else -> 0
}

fun fixScore(move: String) = when (move) {
    "A" -> 1
    "B" -> 2
    "C" -> 3
    else -> 0
}

fun List<String>.createFixedRound() = FixedRound(opponentsMove = this.first(), outcome = this.last())
