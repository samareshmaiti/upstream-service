//package com.stackroute.succour.upstreamservice.controller;
//
//import com.stackroute.succour.upstreamservice.config.KafkaSender;
//import com.stackroute.succour.upstreamservice.domain.ActivityData;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class KafkaController {
//    @Autowired
//    KafkaSender kafkaSender;
//
//    @PostMapping("/produce")
//    public String produceData(@RequestBody ActivityData car) {
//
//        System.out.println("REQUEST BODY..!! "+  car);
//
//        kafkaSender.send(car);
//
//        return "Produced to Kafka Topic !!";
//
//    };
//}
