package com.stackroute.succpur.upstreamservice.service;

import com.ibm.common.activitystreams.Activity;
import com.ibm.common.activitystreams.IO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;

import static com.ibm.common.activitystreams.IO.makeDefaultPrettyPrint;
import static com.ibm.common.activitystreams.Makers.activity;
import static com.ibm.common.activitystreams.Makers.object;


@Service
public class DataService {
    Logger logger = (Logger) LoggerFactory.getLogger(DataService.class);
    // The IO object handles all of the reading and writing of the object
    private static final IO io = makeDefaultPrettyPrint();

    private DataService() {
    }

    /**
     * Method main.
     *
     * @return
     * @throws Exception
     */

    public static Activity createActivity() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Activity activity =
                activity()
                        .verb("post")
                        .actor(
                                object("twitter")
                                        .id("default")
                                        .displayName("name")
                        )
                        .object(
                                object("note")
                                        .id("data")
                                        .title("This is the activity"))
                        .get();

        activity.writeTo(out, io);
        return activity;
    }

    @Scheduled(fixedDelay = 2000)
    public static Activity getActivity() throws Exception {
        Activity activity = DataService.createActivity();

        return activity;
    }

    @Scheduled(fixedDelay = 2000)
    public static Activity returnActivity() throws Exception {
        Activity activity = DataService.getActivity();
        System.out.println(getActivity());
        return activity;

    }
}
