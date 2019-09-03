package com.stackroute.succpur.upstreamservice.controller;


import com.ibm.common.activitystreams.Activity;
import com.stackroute.succpur.upstreamservice.service.DataService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
    @RequestMapping("/hello")
    public Activity getDetails() throws Exception
    {
        DataService dataService;
        return DataService.getActivity();
    }

}
