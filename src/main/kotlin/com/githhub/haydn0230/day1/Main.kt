package com.githhub.haydn0230.day1

import java.io.File

fun main(args: Array<String>) {
    val fileName = System.getenv("DATA_FILE")
    val currentPath = System.getenv("DIRECTORY")
    val target = System.getenv("TARGET")

    val data = mutableListOf<Int>()
    File("$currentPath/$fileName").bufferedReader().use { br ->
        br.forEachLine { line ->
            data.add(line.toInt())
        }
    }

    val expenseReport = ExpenseReport(target.toInt(), data)

    println("The answer for part one is: ${expenseReport.checkTwoEntries()}")
    println("The answer for part two is: ${expenseReport.checkThreeEntries()}")
}