package com.githhub.haydn0230.day1

class ExpenseReport(
    private val target: Int,
    private val entries: List<Int>
) {
    fun checkTwoEntries(): Int? {
        // create a map of values where we've taken the number from the target
        val complementMap = entries.associateBy { number -> target - number }
        // loop through entries
        val pair = entries.firstNotNullOf { number ->
            // find the corresponding value to the entry in the complement map
            val complement = complementMap[number]
            // if there is no complement then we don't have two values that make the target
            if (complement != null) {
                // create a generic pair object
                Pair(number, complement)
            } else null
            // return the first pair object
        }
        return pair.first * pair.second

//       ------ this solution is a n^2 solution not as performant as the above
//        var result: Int = 0
//        entries.forEach { firstNumber ->
//            entries.forEach { secondNumber ->
//                if (firstNumber + secondNumber == target) {
//                    result = firstNumber * secondNumber
//                }
//            }
//        }
//        return result
    }




    fun checkThreeEntries(): Int? {
        // associate with sets the key to the it element and the result from entries is the value
        val complement = entries.associateWith { first ->
            // if the current number is 1000 and target is 2020 we want to find two a numbers that equal 1200
            entries.findTwoNumbers(target - first)
        }
        // loop through the entries and find a value in the complement map where the pair isn't null ie 1000 = Pair(600, 600)
        val triple  = entries.firstNotNullOf { number ->
            val pair = complement[number]
            if (pair != null) {
                Triple(pair.first, pair.second, number)
            } else null
        }

        return triple.first * triple.second * triple.third

//       ------ this solution is a n^3 solution not as performant as the above
//        var result: Int = 0
//        entries.forEach { firstNumber ->
//            entries.forEach { secondNumber ->
//                entries.forEach { thirdNumber ->
//                    if (firstNumber + secondNumber + thirdNumber == target) {
//                        result = firstNumber * secondNumber * thirdNumber
//                    }
//                }
//            }
//        }
//        return result
    }

    fun List<Int>.findTwoNumbers(sum: Int): Pair<Int, Int>? {
        val complementMap = associateBy { number -> sum - number }
        // loop through entries
        val pair = firstNotNullOfOrNull { number ->
            // find the corresponding value to the entry in the complement map
            val complement = complementMap[number]
            // if there is no complement then we don't have two values that make the target
            if (complement != null) {
                // create a generic pair object
                Pair(number, complement)
            } else null
            // return the first pair object
        }
        return pair
    }

}
