/**
 * Copyright(c) 2004-2018 by qyer.com All rights reserved.
 */
package com.example;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.schedule.ScheduleResult;

/**
 * @author Tony
 * @date 2018-03-05
 * @version 1.0
 */
public class PushTest {

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test method for
     * {@link com.example.Push#push4Android(java.lang.String, java.lang.String, java.lang.String[])}.
     */
    @Test
    public void testPush4Android() {
        PushResult pr;
        try {
            pr = Push.push4Android("test alert", "test title",
                "120c83f7602f7e4d8be");
            System.out.println(pr.getResponseCode());
            System.out.println(pr.getOriginalContent());
        } catch (APIConnectionException | APIRequestException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test method for
     * {@link com.example.Push#push4AndroidByTime(java.lang.String, java.lang.String, java.lang.String, java.lang.String[])}.
     */
    @Test
    public void testPush4AndroidByTime() {
        ScheduleResult sr;
        try {
            sr = Push.push4AndroidByTime("test time alert", "test time title",
                "2018-03-05 22:15:00", "120c83f7602f7e4d8be");
            System.out.println(sr.getResponseCode());
            System.out.println(sr.getOriginalContent());
        } catch (APIConnectionException | APIRequestException e) {
            e.printStackTrace();
        }
    }

}
