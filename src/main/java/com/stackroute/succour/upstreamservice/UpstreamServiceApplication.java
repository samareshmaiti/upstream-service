package com.stackroute.succour.upstreamservice;


import com.stackroute.succour.upstreamservice.service.DataService;
//import com.stackroute.succour.upstreamservice.service.SendDataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;


@Import(DataService.class)
@EnableScheduling
@SpringBootApplication

public class UpstreamServiceApplication {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(UpstreamServiceApplication.class, args);

  //      SendDataService sendDataService=new SendDataService();
     //   sendDataService.sendToKafka(activityData);
        DataService dataService=new DataService();
     //   dataService.getActivity1();
       dataService.getActivity();





    }

}
