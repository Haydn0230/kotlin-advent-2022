fun main(args: Array<String>) {
    val socket = java.net.Socket("localhost", 8282)
    val reader = socket.getInputStream().bufferedReader()
    for (line in reader.lines()) {
        val sanitisedStrings = sanitise(line)
        println(sanitisedStrings)
        // create header

        // process header

        // process event type

        // parse into json
    }
}
