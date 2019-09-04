package com.stackroute.succour.upstreamservice;

import com.stackroute.succour.upstreamservice.config.KafkaSender;
import com.stackroute.succour.upstreamservice.service.DataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;



@EnableScheduling
@SpringBootApplication
public class UpstreamServiceApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(UpstreamServiceApplication.class, args);



    }

}
