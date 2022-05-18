import models.message.Message
import models.header.Header
import models.body.Body
import models.outcome.Outcome
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MainKtTest {
    private val testCases = mapOf<String, List<String>>(
        "outcome" to listOf<String>(
            "45567",
            "update",
            "outcome",
            "1652879071966",
            "0c6d9e95-ca92-482c-b568-1ab83b5f36e7",
            "d7bf2e18-a0ea-47f4-82e2-1809227e49ae",
            "Derby",
            "8/11",
            "1",
            "0"
        )
    )
    val expectedResults = mapOf<String, Message>(
        "outcome" to Message(
            header = Header(msgId = 45567, operation = "update", type = "outcome", 1652879071966),
            body = Outcome(
                marketId = "0c6d9e95-ca92-482c-b568-1ab83b5f36e7",
                outcomeId = "d7bf2e18-a0ea-47f4-82e2-1809227e49ae",
                name = "Derby",
                price = "8/11",
                displayed = true,
                suspended = false
            )
        ))
        @Test
        fun `returns an outcome message type`() {
            val result = testCases["outcome"]?.let { createMessage(it) }
            assertEquals(expectedResults["outcome"], result)
        }
}
