package com.stackroute.succour.upstreamservice.config;

import com.ibm.common.activitystreams.Activity;
import com.stackroute.succour.upstreamservice.domain.ActivityData;
import com.stackroute.succour.upstreamservice.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaSender.class);

    @Value("${kafka.topic.json}")
    private String jsonTopic;

    @Autowired
    private KafkaTemplate<Activity, ActivityData> kafkaTemplate;

    public void  send(ActivityData service) {
        LOGGER.info("sending activity", service);
        kafkaTemplate.send(jsonTopic, service);
    }
}
