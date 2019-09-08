package com.stackroute.succour.upstreamservice.config;

import com.stackroute.succour.upstreamservice.domain.ActivityData;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
@Configuration
@EnableKafka
public class KStreamConfig {
    public static void main(String[] args) throws Exception{

        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-application");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "0.0.0.0:9092");
        Map<String, Object> serdeProps = new HashMap<>();


        final Serializer<ActivityData> KafkaRunApplicationSerialzer = new JsonPOJOSerializer<>();
        serdeProps.put("JsonPOJOClass", ActivityData.class);
        KafkaRunApplicationSerialzer.configure(serdeProps, false);


        final Deserializer<ActivityData> KafkaRunDeserializer = new JsonPOJODeserializer<>();
        serdeProps.put("JsonPOJOClass", ActivityData.class);
        KafkaRunDeserializer.configure(serdeProps, false);

//        final Serdes<> KafkaRunApplicationSerDes = ;
        final Serde<ActivityData> KafkaRunApplicationSerdes = Serdes.serdeFrom(KafkaRunApplicationSerialzer, KafkaRunDeserializer);

        StreamsBuilder builder = new StreamsBuilder();

        KStream<String, ActivityData> textLines = builder.stream("TextLinesTopic", Consumed.with(Serdes.String(), KafkaRunApplicationSerdes));
        textLines.map((i, j) -> {
            System.out.println("hello"+i);
            System.out.println(j);
            return KeyValue.pair(i, j);
        });
        KafkaStreams streams = new KafkaStreams(builder.build(), props);
        streams.start();
    }
}



