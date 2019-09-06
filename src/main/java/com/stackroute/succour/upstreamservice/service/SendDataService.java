package com.stackroute.succour.upstreamservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SendDataService {
    @Autowired
    private  KafkaTemplate<String,String> kafkaTemplate;

    private  final String TOPIC = "hello-topic";

//    public  String sendToKafka(ActivityDataNewsAPI activityData) throws Exception {
//        // DataService activityData=new DataService();
////        activityData.setActivity(DataService.getActivity());
//        System.out.println("hey");
////        System.out.println(activityData);
//
//
//        try {
//
//            String ba = new ObjectMapper().writeValueAsString(activityData);
//            System.out.println("Data to send"+ ba);
////            System.out.println(kafkaTemplate.send(TOPIC, ba));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "sent data to kafka";
//    }
}
