package com.stackroute.succour.upstreamservice.controller;

import com.ibm.common.activitystreams.Activity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/data")
public class KafkaController {
    @GetMapping
    public List<Activity> getAll() throws Exception {

        //  return new TwitterMicroserviceApplication().getTweets();
        return  null;
    }


}
