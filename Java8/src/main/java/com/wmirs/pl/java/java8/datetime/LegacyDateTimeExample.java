package com.wmirs.pl.java.java8.datetime;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @Desc
 * @Author WangMu
 * @Create 2022-05-05
 */
public class LegacyDateTimeExample {

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();
        System.out.println(calendar);
        System.out.println(calendar.toInstant());
    }
}
