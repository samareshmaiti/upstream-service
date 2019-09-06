package com.stackroute.succour.upstreamservice.service;

import com.ibm.common.activitystreams.IO;
import com.stackroute.socketone.adapter.Tweets;
import com.stackroute.succour.newsapiadapter.adapter.NewsAPIAdapter;

import com.stackroute.succour.upstreamservice.domain.ActivityData;
import com.stackroute.succour.upstreamservice.domain.ObjNewsAPI;
import com.stackroute.succour.upstreamservice.domain.ObjTwitterAPI;
import com.stackroute.succour.upstreamservice.domain.Objects;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.Disposable;

import java.io.IOException;

import static com.ibm.common.activitystreams.IO.makeDefaultPrettyPrint;


@Service

public class DataService {
    private ActivityData activityData;
    @Autowired
    private ObjNewsAPI objNewsAPI;
    private ObjTwitterAPI objTwitterAPI;


    Objects objects = new Objects();


    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public  NewsAPIAdapter newsAPIAdapter;
  public Tweets tweets;
    Logger logger = (Logger) LoggerFactory.getLogger(DataService.class);
    // The IO object handles all of the reading and writing of the object
    private  final IO io = makeDefaultPrettyPrint();

    public DataService() {
        try {
            newsAPIAdapter = new NewsAPIAdapter();
            newsAPIAdapter.addQueryParam("india");
           // newsAPIAdapter.startNewsStream();

tweets=new Tweets();
tweets.getTweets();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }


    /**
     * Method main.
     *
     * @return
     * @throws Exception
     */



    public String getActivity() throws Exception {
        objNewsAPI=new ObjNewsAPI();
        newsAPIAdapter.startNewsStream();
        newsAPIAdapter.getArticleSubject().subscribe(i-> {

            System.out.println(i);
            objNewsAPI.setContent(newsAPIAdapter.getArticleSubject().toString());
            objNewsAPI.setObjectType(newsAPIAdapter.getArticleSubject().toString());
            System.out.println(objNewsAPI.toString());

            objects.setObjNewsAPI(objNewsAPI);
            activityData.setObjects(objects);


        });
//        newsAPIAdapter.getArticleSubject().subscribe(j-> {
//            activityData.setObjects(activityData.toString());
//
//        });

//        newsAPIAdapter.getArticleSubject().subscribe(article -> {
//            activityData.setActivity(article.toString());
//           // activityData.setActivity(activityData.toString());
//            System.out.println("hello  "+activityData);
//            kafkaTemplate.send("hello-topic", activityData.toString());
//
//        });
        newsAPIAdapter.getArticleSubject().subscribe();

        return newsAPIAdapter.toString();
    }

    @Scheduled(fixedDelay = 2000)
    public Disposable  getActivity1() throws Exception {
//        objTwitterAPI=new ObjTwitterAPI();
//        objTwitterAPI.setObjectType(tweets.publisher().toString());
//        objTwitterAPI.setContext(tweets.publisher().toString());

//        activityData.setActivity(tweets.publisher().toString());
//        System.out.println(activityData.getActivity());
        //System.out.println(tweets.getClass());

     return tweets.publisher();

    }
}