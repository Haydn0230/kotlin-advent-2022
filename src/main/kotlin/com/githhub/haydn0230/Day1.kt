package com.githhub.haydn0230

import java.io.File

fun sumCaloriesByElf(emptyIndexes: List<Int>, file: List<String>) = (listOf(0) + emptyIndexes + file.size)
    .windowed(2, 1)
    .map { (start, end) ->
        file.subList(start + 1, end).sumOf {
            it.toInt()
        }
    }



fun main(args: Array<String>) {
    val fileName = System.getenv("DATA_FILE")
    val currentPath = System.getenv("DIRECTORY")
    val file = File("$currentPath/$fileName").readLines()
    val emptyIndexes = file.mapIndexedNotNull { index, string -> if (string.isEmpty()) index else null }
    val summedCalories = sumCaloriesByElf(emptyIndexes, file)

    val highestCalories = summedCalories.maxOrNull()
    val topThreeTotal = summedCalories.sortedDescending().subList(0, 3).sum()
    println("The elf with the most calories is carrying $highestCalories calories while the top three have $topThreeTotal calories")

}

