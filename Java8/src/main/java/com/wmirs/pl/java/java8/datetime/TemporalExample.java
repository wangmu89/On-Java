package com.wmirs.pl.java.java8.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * @Desc
 * @Author WangMu
 * @Create 2022-05-03
 */
public class TemporalExample {

    public static void main(String[] args) {
//        System.out.println(LocalDate.now().isSupported(ChronoField.CLOCK_HOUR_OF_DAY));
//        System.out.println(LocalDate.now().isSupported(ChronoUnit.MINUTES));
//        System.out.println(Instant.now().isSupported(ChronoUnit.HOURS));
//        System.out.println(Instant.now().isSupported(ChronoUnit.DAYS));
//        System.out.println(Instant.now().isSupported(ChronoUnit.MONTHS));
//        System.out.println(Instant.now().isSupported(ChronoUnit.YEARS));

        temporalAdjuster();
    }

    private static void temporalAdjuster() {
        // Predefined Adjusters
        LocalDate date = LocalDate.of(2022, 5, 7);
        DayOfWeek dow = date.getDayOfWeek();
        // SATURDAY
        System.out.printf("%s is a %s%n", date, dow);
        System.out.printf("当月的第一天: %s%n", date.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.printf("当月的第一个周一: %s%n", date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
        System.out.printf("当月的最后一天: %s%n", date.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.printf("下个月的第一天: %s%n", date.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.printf("明年的第一天: %s%n", date.with(TemporalAdjusters.firstDayOfNextYear()));
        System.out.printf("今年的第一天: %s%n", date.with(TemporalAdjusters.firstDayOfYear()));

        // Custom Adjusters
        LocalDate payDate = LocalDate.of(2022, 4, 10);
        System.out.println(payDate.with(new PaydayAdjuster()));
        payDate = LocalDate.of(2022, 4, 16);
        System.out.println(payDate.with(new PaydayAdjuster()));
    }
}
