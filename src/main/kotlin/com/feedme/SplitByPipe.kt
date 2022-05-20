package com.feedme


fun splitByPipe(line: String): List<String> =
    line.replace("\\|", "@")
        .split("|")
        .filter { it != "" }
        .map { it.replace("@", "|") }



