package com.stackroute.succpur.upstreamservice;

import com.stackroute.succpur.upstreamservice.service.DataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Timer;

@Import(DataService.class)
@SpringBootApplication
@EnableScheduling
public class UpstreamServiceApplication {

    public static void main(String[] args) throws Exception {
        Timer timer = new Timer();
        SpringApplication.run(UpstreamServiceApplication.class, args);
        System.out.println(DataService.returnActivity());


    }

}
