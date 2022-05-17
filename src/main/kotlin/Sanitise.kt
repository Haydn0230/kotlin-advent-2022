fun sanitise(line: String): List<String> {
    val letters = line.split("")
    // flag to skip an escaped pipe
    var skip = false
    val processedStrings = arrayListOf<String>()
    var stringBeingProcessed = ""

    for ( i in letters.indices) {
        when(letters[i]) {
            "|" -> {
                if (skip) {
                    skip = false
                    continue
                }
                // skip first string as we don't want a blank entry
                if (i != 1) { processedStrings.add(stringBeingProcessed) }
                // reset the string for the next process
                stringBeingProcessed = ""
            }
            "\\"-> skip = true
            else -> stringBeingProcessed += letters[i]
        }
    }
    return processedStrings
}
