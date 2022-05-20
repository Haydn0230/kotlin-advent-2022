package com.feedme

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.feedme.models.Message

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import java.util.Properties

class Producer {
    private val producer: Producer<String, String> = createProducer()
    private val jsonMapper = jacksonObjectMapper()

    private fun createProducer(): Producer<String, String> {
        val props = Properties()
        props["bootstrap.servers"] = "localhost:9092"
        props["key.serializer"] = StringSerializer::class.java.canonicalName
        props["value.serializer"] = StringSerializer::class.java.canonicalName
        return KafkaProducer(props)
    }


    fun produce(topic: String, key: String, message: Message) {
        if (message.body == null) return
        val messageJson = jsonMapper.writeValueAsString(message)

        val futureResult = producer.send(ProducerRecord(topic, key, messageJson))
        futureResult.get()
    }

}
