package com.githhub.haydn0230

import java.io.File

fun main(args: Array<String>) {
    val fileName = System.getenv("DATA_FILE")
    val currentPath = System.getenv("DIRECTORY")
    val file = File("$currentPath/$fileName").readLines()
    val width = file[0].length
    val trees = file.indices.count { y ->
        file[y][y*3 % width] == '#'
    }

    print(trees)
}