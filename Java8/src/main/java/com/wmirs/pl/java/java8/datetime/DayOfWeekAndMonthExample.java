package com.wmirs.pl.java.java8.datetime;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * @Desc [DayOfWeek]days of the week
 *       [Month]months of the year
 * @Author WangMu
 * @Create 2022-05-02
 */
public class DayOfWeekAndMonthExample {

    public static void main(String[] args) {
        // WEDNESDAY
        System.out.printf("%s%n", DayOfWeek.SUNDAY.plus(3));
        // Sunday
        System.out.println(DayOfWeek.SUNDAY.getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        // S
        System.out.println(DayOfWeek.SUNDAY.getDisplayName(TextStyle.NARROW, Locale.ENGLISH));
        // Sun
        System.out.println(DayOfWeek.SUNDAY.getDisplayName(TextStyle.SHORT, Locale.ENGLISH));

        // 29
        System.out.printf("%d%n", Month.FEBRUARY.maxLength());
        // October
        System.out.println(Month.OCTOBER.getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        // O
        System.out.println(Month.OCTOBER.getDisplayName(TextStyle.NARROW, Locale.ENGLISH));
        // Oct
        System.out.println(Month.OCTOBER.getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
    }
}
