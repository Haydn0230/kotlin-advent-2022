package com.githhub.haydn0230

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day2Test {

//    val fileName = System.getenv("TEST_DATA_FILE")
//    val currentPath = System.getenv("TEST_DIRECTORY")
//
//    val testData = mutableMapOf <String, String>()
//    val t = File("$currentPath/$fileName").bufferedReader().use { br -> br.forEachLine { line ->
//        val (key, value) = line.split(":")
//        testData[key] = value
//    } }

    @Test
    fun `should return the number of valid passwords`() {
        val testData = mapOf<String, String>(
            "1-3 a" to "abcde",
            "1-3 b" to "cdefg",
            "2-9 c" to "ccccccccc"
        )
        assertEquals(2, day2().numberOfValidPaswords(testData))

    }

    @Test
    fun `should return true when passed a password that matches the rule`() {
        assertTrue(day2().passwordValidator("1-3 w", "dlwwlw"))
    }
}
