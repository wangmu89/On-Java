package com.wmirs.pl.java.java8.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @Desc the start of a nanosecond on the timeline.
 *       EPOCH, 1970-01-01T00:00:00Z
 * @Author WangMu
 * @Create 2022-05-02
 */
public class InstantExample {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);
        Instant oneHourLater = instant.plus(1, ChronoUnit.HOURS);
        System.out.println(instant);
        // 两个Instant对象之间存在的时间
        long seconds = instant.until(oneHourLater, ChronoUnit.SECONDS);
        System.out.println(seconds);

        LocalDateTime dt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(dt);
        OffsetDateTime odt = OffsetDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(odt);
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(zdt);
    }
}
