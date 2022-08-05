package com.githhub.haydn0230

import java.io.File

class day2 {

    fun numberOfValidPaswords(data: Map<String,String>): Int {
        var counter = 0
        data.forEach{ (key, value) ->
            if (passwordValidator(key, value) == true) counter += 1
        }
        return counter
    }

    fun passwordValidator(rule: String, password: String): Boolean {
        val (range,letter) = rule.split(" ")
        val (start, end) = range.split("-")
        var counter = 0
        password.split("").forEach {
            if (it == letter) counter += 1
        }
        //println("range:$range letter:$letter")
        return if (counter >= start.toInt() && counter <= end.toInt() ) true else false
    }
}

fun main(args:Array<String>) {
    val fileName = System.getenv("DATA_FILE")
    val currentPath = System.getenv("DIRECTORY")

    val data = mutableMapOf <String, String>()
    File("$currentPath/$fileName").bufferedReader().use { br -> br.forEachLine { line ->
        val (key, value) = line.split(":")
        data[key] = value
    }}
    val validPasswords = day2().numberOfValidPaswords(data)
    print("number of valid passwords $validPasswords")
}
