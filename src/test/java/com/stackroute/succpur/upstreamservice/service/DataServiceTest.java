package com.stackroute.succpur.upstreamservice.service;

import com.google.common.collect.Iterables;
import com.ibm.common.activitystreams.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class DataServiceTest {
    private DataService dataService;

    @Before
    public void setUp() {
        this.dataService = dataService;
    }

    @After
    public void tearDown() {
        dataService = null;
    }


    @Test
    public void givenINputShouldReturnTheActivityParameters() throws IOException, ClassNotFoundException {

        ASObject obj =
                Makers.object()
                        .id("Succour")
                        .title("This is a product")
                        .action("create", "http://cgi.com/succour/test")
                        .get();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(obj);

        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(in);
        obj = (ASObject) ois.readObject();

        assertNotNull(obj);

        assertEquals("Succour", obj.id());
        assertEquals("This is a product", obj.titleString());
    }

    @Test
    public void givenActivityShouldReturnPositiveResult() throws IOException, ClassNotFoundException {

        ASObject obj =
                Makers.object()
                        .id("test")
                        .title("This is a test")
                        .action("post", "hello")
                        .get();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(obj);

        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(in);
        obj = (ASObject) ois.readObject();

        assertNotNull(obj);

        assertEquals("test", obj.id());
        assertEquals("This is a test", obj.titleString());

        ActionsValue actions = obj.actions();
        Iterable<LinkValue> lvs = actions.get("post");
        LinkValue lv = Iterables.getFirst(lvs, null);
        assertEquals(ValueType.SIMPLE, lv.valueType());
        LinkValue.SimpleLinkValue slv = (LinkValue.SimpleLinkValue) lv;
        assertEquals("hello", slv.url());

    }

    @Test
    public void givenInputShouldTestLanguageContext() {
        ASObject obj =
                Makers.object()
                        .language("en")
                        .title("en", "Foo")
                        .get();
        assertEquals("Foo", obj.titleString("en"));
        NLV nlv = obj.title();
        assertEquals(ValueType.OBJECT, nlv.valueType());
        NLV.MapNLV map = (NLV.MapNLV) nlv;
        assertTrue(map.has("en"));
        assertEquals("Foo", map.value("en"));

    }



}