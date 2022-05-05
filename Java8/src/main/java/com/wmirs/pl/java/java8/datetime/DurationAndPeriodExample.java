package com.wmirs.pl.java.java8.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

/**
 * @Desc
 * @Author WangMu
 * @Create 2022-05-05
 */
public class DurationAndPeriodExample {

    public static void main(String[] args) {
        duration();

        chronoUnit();

        period();
    }

    private static void duration() {
        Instant t1 = Instant.from(OffsetDateTime.of(LocalDateTime.of(2022, 5, 1, 0, 0), ZoneOffset.of("+08:00")));
        Instant t2 = Instant.from(OffsetDateTime.of(LocalDateTime.of(2022, 5, 1, 23, 59), ZoneOffset.of("+08:00")));
        Duration duration = Duration.between(t1, t2);
        System.out.println(duration.getSeconds());
        System.out.println(duration.toMinutes());
        System.out.println(duration.toHours());
        System.out.println(duration.toDays());
        System.out.println(duration.toString());

        Instant start = Instant.from(OffsetDateTime.of(LocalDateTime.of(2022, 5, 1, 0, 0), ZoneOffset.of("+08:00")));
        Duration d1 = Duration.ofSeconds(10);
        Instant end = start.plus(d1);
        System.out.printf("Start: %s, End: %s%n", start, end);
    }

    private static void chronoUnit() {
        Instant t1 = Instant.from(OffsetDateTime.of(LocalDateTime.of(2022, 5, 1, 0, 0), ZoneOffset.of("+08:00")));
        Instant t2 = Instant.from(OffsetDateTime.of(LocalDateTime.of(2022, 5, 1, 23, 59), ZoneOffset.of("+08:00")));

        System.out.println(ChronoUnit.MILLIS.between(t1, t2));
        System.out.println(ChronoUnit.SECONDS.between(t1, t2));
        System.out.println(ChronoUnit.MINUTES.between(t1, t2));
        System.out.println(ChronoUnit.HOURS.between(t1, t2));
        System.out.println(ChronoUnit.HALF_DAYS.between(t1, t2));
        System.out.println(ChronoUnit.DAYS.between(t1, t2));
    }

    private static void period() {
        LocalDate birthday = LocalDate.of(2020, 1, 1);
        LocalDate today = LocalDate.of(2022, 5, 5);
        Period p = Period.between(birthday, today);
        long days = ChronoUnit.DAYS.between(birthday, today);
        System.out.println("You are " + p.getYears() + " years, " + p.getMonths() +
                " months, and " + p.getDays() +
                " days old. (" + days + " days total)");
        LocalDate nextBirthday = birthday.withYear(today.getYear());
        if(nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }
        Period p1 = Period.between(today, nextBirthday);
        long days1 = ChronoUnit.DAYS.between(today, nextBirthday);
        System.out.println("There are " + p1.getMonths() + " months, and " +
                p1.getDays() + " days until your next birthday. (" +
                days1 + " total)");
    }
}
