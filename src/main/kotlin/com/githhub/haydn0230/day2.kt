package com.githhub.haydn0230

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
