package producer

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import models.message.Message

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import java.util.Properties

class Producer() {
    private val jsonMapper = jacksonObjectMapper()
    fun createProducer(brokers: String): org.apache.kafka.clients.producer.Producer<String, String> {
        val props = Properties()
        props["bootstrap.servers"] = brokers
        props["key.serializer"] = StringSerializer::class.java.canonicalName
        props["value.serializer"] = StringSerializer::class.java.canonicalName
        return KafkaProducer(props)
    }


    fun produce(producer: Producer<String, String>, topic: String, key: String, message: Message) {
        if (message.body == null) return
        val messageJson = jsonMapper.writeValueAsString(message)

        val futureResult = producer.send(ProducerRecord(topic, key,  messageJson))
        futureResult.get()
    }

}
