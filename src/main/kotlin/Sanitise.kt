fun sanitise(line: String): List<String> {
    val letters = line.split("")
    // flag to skip an escaped pipe
    var skip = false
    val processedStrings = arrayListOf<String>()
    var stringBeingProcessed = ""

    for ( i in 0 until letters.size) {
        when(letters[i]) {
            "|" -> {
                if (skip) continue
                if (i != 1) { processedStrings.add(stringBeingProcessed) }
                stringBeingProcessed = ""
            }
            "\\"-> skip = true
            else -> stringBeingProcessed += letters[i]
        }
    }
    return processedStrings
}
