package strings

// is this a golden hammer? Should probably not include
// business logic in an extension of strings package
fun String.splitByPipe(): MutableList<String> {
    val letters = split("")
    val processedStrings = mutableListOf<String>()
    // flag to skip an escaped pipe
    var skip = false
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
