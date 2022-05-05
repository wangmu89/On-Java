package com.wmirs.pl.java.java8.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;

/**
 * @Desc [LocalTime] deals in time only, representing human-based time of day, create a digital clock,
 *                   does not store time zone or daylight saving time information
 *       [LocalDateTime] handles both date and time, without a time zone
 *                       This class is used to represent date (month-day-year) together with time (hour-minute-second-nanosecond)
 * @Author WangMu
 * @Create 2022-05-02
 */
public class DateAndTimeClassesExample {

    public static void main(String[] args) {
        localTime();
        System.out.println("===== LocalTime =====");
        localDateTime();
        System.out.println("===== LocalDateTime =====");
    }

    private static void localTime() {
        LocalTime thisSec = LocalTime.now();
        System.out.println(thisSec);
        // 10:30
        LocalTime time = LocalTime.of(10, 30);
        System.out.println(time);
    }

    private static void localDateTime() {
        System.out.printf("now: %s%n", LocalDateTime.now());

        System.out.printf("Apr 15, 1994 @ 11:30am: %s%n",
                LocalDateTime.of(1994, Month.APRIL, 15, 11, 30));

        System.out.printf("now (from Instant): %s%n",
                LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));

        System.out.printf("6 months from now: %s%n",
                LocalDateTime.now().plusMonths(6));

        System.out.printf("6 months ago: %s%n",
                LocalDateTime.now().minusMonths(6));

    }
}
