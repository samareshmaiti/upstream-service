package com.stackroute.succour.upstreamservice.service;

import com.ibm.common.activitystreams.IO;

import com.stackroute.succour.newsapiadapter.adapter.NewsAPIAdapter;
import com.stackroute.succour.newsapiadapter.exceptions.EmptyAPIQueryURIException;
import com.stackroute.succour.newsapiadapter.exceptions.EmptyQueryParamsException;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.ibm.common.activitystreams.IO.makeDefaultPrettyPrint;
import com.stackroute.socketone.controller.*;

//import com.stackroute.succour.newsapiadapter.exceptions.EmptyAPIQueryURIException;
//import com.stackroute.succour.newsapiadapter.exceptions.EmptyQueryParamsException;


@Service
public class DataService {
    private static NewsAPIAdapter newsAPIAdapter;
private static Tweets tweets;
    Logger logger = (Logger) LoggerFactory.getLogger(DataService.class);
    // The IO object handles all of the reading and writing of the object
    private static final IO io = makeDefaultPrettyPrint();

    private DataService() {
        try {
            newsAPIAdapter = new NewsAPIAdapter();
            newsAPIAdapter.addQueryParam("india");
            newsAPIAdapter.startNewsStream();
            tweets=new Tweets();
            tweets.getTweets();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (EmptyAPIQueryURIException e) {
            e.printStackTrace();
        } catch (EmptyQueryParamsException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method main.
     *
     * @return
     * @throws Exception
     */


    @Scheduled(fixedDelay = 2000)
    public static NewsAPIAdapter getActivity() throws Exception {

    newsAPIAdapter.getNewsStream().subscribe(article -> System.out.println(article));

        return newsAPIAdapter;
    }
    @Scheduled(fixedDelay = 2000)
    public static Tweets getActivity1() throws Exception {

       tweets.getTweets().subscribe(tweets-> System.out.println(tweets));
     // tweets.met(8091);

        return tweets;
    }



}
