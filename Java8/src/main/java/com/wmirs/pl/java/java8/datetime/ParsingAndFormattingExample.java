package com.wmirs.pl.java.java8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Desc
 * @Author WangMu
 * @Create 2022-05-03
 */
public class ParsingAndFormattingExample {

    public static void main(String[] args) {
        parsing();
        formatting();
    }

    private static void parsing() {
        String str = "19590709";
        System.out.println(LocalDate.parse(str, DateTimeFormatter.BASIC_ISO_DATE));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy");
        System.out.println(LocalDate.parse("Jan 3 2003", formatter));
        System.out.println(LocalDate.parse("Jan 23 1995", formatter));
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMM dd yyyy");
        System.out.println(LocalDate.parse("Jan 03 2003", formatter2));
        System.out.println(LocalDate.parse("Jan 23 1995", formatter2));
    }

    private static void formatting() {
        LocalDateTime leaving = LocalDateTime.of(2013, 7, 20, 19, 30);
        ZoneId leavingZone = ZoneId.of("America/Los_Angeles");
        ZonedDateTime departure = ZonedDateTime.of(leaving, leavingZone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");
        System.out.printf("LEAVING:  %s (%s)%n", departure.format(formatter), leavingZone);
    }
}
