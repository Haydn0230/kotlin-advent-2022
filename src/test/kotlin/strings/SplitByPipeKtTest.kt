package strings

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SplitByPipeKtTest {
    @Test
    fun `string with pipe is correctly separated`(){
        val testCase = "|44828|update|outcome|"
        val expected = listOf("44828","update","models")
        assertLinesMatch(testCase.splitByPipe(), expected)

    }
    @Test
    fun `string with escaped pipe is ignored`(){
        val testCase = "f82c2dbae6da|\\|Luton \\| 0-3|1/9|"
        val expected = listOf("f82c2dbae6da","Luton 0-3","1/9")
        assertLinesMatch(testCase.splitByPipe(), expected)

    }
}
