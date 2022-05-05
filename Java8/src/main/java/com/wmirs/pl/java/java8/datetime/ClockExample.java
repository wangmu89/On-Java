package com.wmirs.pl.java.java8.datetime;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * @Desc
 * @Author WangMu
 * @Create 2022-05-05
 */
public class ClockExample {

    public static void main(String[] args) {
        Instant instant = Instant.from(OffsetDateTime.of(LocalDateTime.of(2022, 5, 5, 12, 0), ZoneOffset.of("+08:00")));

        System.out.println(Clock.fixed(instant, ZoneId.systemDefault()));

        System.out.println(Clock.fixed(instant, ZoneId.of("America/Los_Angeles")));

        System.out.println(Clock.fixed(instant, ZoneId.of("Asia/Shanghai")));

        System.out.println(Clock.fixed(instant, ZoneId.of("Asia/Tokyo")));

        System.out.println(Clock.systemDefaultZone());
    }
}
