package strings

import com.feedme.splitByPipe
import org.junit.jupiter.api.Assertions.assertLinesMatch
import org.junit.jupiter.api.Test

internal class SplitByPipeTest {
    @Test
    fun `string with pipe is correctly separated`() {
        val testCase = "|44828|update|outcome|"
        val expected = listOf("44828", "update", "outcome")
        assertLinesMatch(expected, splitByPipe(testCase))

    }

    @Test
    fun `string with escaped pipe is ignored`() {
        val testCase = "f82c2dbae6da|\\|Luton \\|0-3|1/9|"
        val expected = listOf("f82c2dbae6da", "|Luton |0-3", "1/9")
        assertLinesMatch(expected, splitByPipe(testCase))

    }
}
