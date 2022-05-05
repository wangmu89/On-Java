package com.wmirs.pl.java.java8.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjusters;

/**
 * @Desc deal exclusively with date information, without respect to time or time zone.
 *       [LocalDate] year-month-day in the ISO calendar
 *       [YearMonth] the month of a specific year
 *       [MonthDay]  the day of a particular month
 *       [Year]      a year
 * @Author WangMu
 * @Create 2022-05-02
 */
public class DateClassesExample {

    public static void main(String[] args) {
        localDate();
        System.out.println("===== LocalDate =====");
        yearMonth();
        System.out.println("===== YearMonth =====");
        monthDay();
        System.out.println("===== MonthDay =====");
        year();
        System.out.println("===== Year =====");
    }

    private static void localDate() {
        // 2022-10-01
        LocalDate date = LocalDate.of(2022, Month.OCTOBER, 1);
        System.out.println(date);
        // SATURDAY
        System.out.println(date.getDayOfWeek());
        // OCTOBER
        System.out.println(date.getMonth());
        // 1
        System.out.println(date.getDayOfMonth());
        // 274
        System.out.println(date.getDayOfYear());
        // 2022-10-05
        LocalDate nextWednesday = date.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        System.out.println(nextWednesday);
    }

    private static void yearMonth() {
        YearMonth ym1 = YearMonth.of(2010, 2);
        YearMonth ym2 = YearMonth.of(2012, 2);
        // 28
        System.out.println(ym1.lengthOfMonth());
        // 2010-02-28
        System.out.println(ym1.atEndOfMonth());
        // 29
        System.out.println(ym2.lengthOfMonth());
        // 2012-02-29
        System.out.println(ym2.atEndOfMonth());
    }

    private static void monthDay() {
        MonthDay md = MonthDay.of(Month.FEBRUARY, 29);
        // false
        System.out.println(md.isValidYear(2010));
        // true
        System.out.println(md.isValidYear(2012));
    }

    private static void year() {
        // false
        System.out.println(Year.of(2010).isLeap());
        // true
        System.out.println(Year.of(2012).isLeap());
    }
}
