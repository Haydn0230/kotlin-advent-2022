fun main(args: Array<String>) {
    val socket = java.net.Socket("localhost", 8282)
    val reader = socket.getInputStream().bufferedReader()
    for (line in reader.lines()) {
        val sanitisedStrings = sanitise(line)

        // process header


        // get each part out between the pipe
        // loop over the first 4 and load them into a header class
        // check the type and then send for specific processing for that data class
        // add to a map
        //



//        letters.forEach() { letter ->
//        }

//        println(line)

    }
}
