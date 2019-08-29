package com.stackroute.succpur.upstreamservice.service;

import com.ibm.common.activitystreams.Activity;
import com.ibm.common.activitystreams.IO;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import static com.ibm.common.activitystreams.IO.makeDefaultPrettyPrint;
import static com.ibm.common.activitystreams.Makers.activity;


@Service
public class DataService {
    // The IO object handles all of the reading and writing of the object
    private static final IO io = makeDefaultPrettyPrint();

    private DataService() {}

    /**
     * Method main.

     * @throws Exception
     * @return */

    public static Activity result() throws Exception {

        Activity activity =
                activity()
                        .verb("post")
                        .actor("acct:joe@example.org")
                        .object("http://example.net/posts/1")
                        .get();

        // let's write it out to our outputstream
        ByteArrayInputStream out = new ByteArrayInputStream("{\"verb\":\"post\",\"actor\":\"acct:joe@example.org\",\"object\":\"http://example.net/posts/1\"}".getBytes());

      activity=io.readAsActivity(out);
        System.out.println(activity);

    return activity;
    }
}
