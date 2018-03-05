/**
 * Copyright(c) 2004-2018 by qyer.com All rights reserved.
 */
package com.example;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;
import cn.jpush.api.schedule.ScheduleResult;

/**
 * @author Tony
 * @date 2018-03-05
 * @version 1.0
 */
public class Push {

    private static final JPushClient CLIENT = new JPushClient(
        Constants.MASTER_SECRET, Constants.APP_KEY);

    public static PushResult push4Android(String alert, String title,
        String... registrationId)
        throws APIConnectionException, APIRequestException {
        PushPayload payload = PushPayload.newBuilder()
            .setPlatform(Platform.android())
            .setAudience(Audience.registrationId(registrationId))
            .setNotification(Notification.android(alert, title, null)).build();
        return CLIENT.sendPush(payload);
    }

    public static ScheduleResult push4AndroidByTime(String alert, String title,
        String time, String... registrationId)
        throws APIConnectionException, APIRequestException {
        PushPayload payload = PushPayload.newBuilder()
            .setPlatform(Platform.android())
            .setAudience(Audience.registrationId(registrationId))
            .setNotification(Notification.android(alert, title, null)).build();
        return CLIENT.createSingleSchedule("push4AndroidByTime", time, payload);
    }

}
