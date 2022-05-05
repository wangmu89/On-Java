package com.wmirs.pl.java.java8.datetime;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javafx.util.Pair;

/**
 * @Desc time zone: 使用相同标准时间的地球区域
 *                  Each time zone is described by an identifier and usually has the format region/city (Asia/Tokyo) and an offset from Greenwich/UTC time. For example, the offset for Tokyo is +09:00.
 *                 [ZoneId] specifies a time zone identifier and provides rules for converting between an Instant and a LocalDateTime.
 *                 [ZoneOffset] specifies a time zone offset from Greenwich/UTC time. defined in whole hours.
 *       The Date-Time Classes：three temporal-based classes that work with time zones
 *       [ZonedDateTime]  handles a date and time with a corresponding time zone with a time zone offset from Greenwich/UTC.
 *       [OffsetDateTime] handles a date and time with a corresponding time zone offset from Greenwich/UTC, without a time zone ID.
 *       [OffsetTime]     handles time with a corresponding time zone offset from Greenwich/UTC, without a time zone ID.
 *       OffsetDateTime vs ZonedDateTime ?
 *       ZonedDateTime适用于夏令时，用ZoneRules来确定特定时区的偏移量如何变化。
 * @Author WangMu
 * @Create 2022-05-02
 */
public class TimeZoneAndOffsetClassesExample {

    public static void main(String[] args) {
        timeZoneId();
//        zonedDateTime();
        offsetDateTime();
    }

    private static void timeZoneId() {
        // Create a List using the set of zones and sort it.
        List<String> zoneIdList = ZoneId.getAvailableZoneIds().stream().sorted().collect(Collectors.toList());
        LocalDateTime dt = LocalDateTime.now();
        List<Pair<ZoneId, ZoneOffset>> idAndOffsetList = new ArrayList<>();
        for(String id : zoneIdList) {
            ZoneId zoneId = ZoneId.of(id);
            ZonedDateTime zdt = dt.atZone(zoneId);
            ZoneOffset zoneOffset = zdt.getOffset();

            idAndOffsetList.add(new Pair<>(zoneId, zoneOffset));
        }
        idAndOffsetList.sort(Comparator.comparing(Pair::getValue));
        // 打印所有的时区Id、时区Offset
        idAndOffsetList.forEach(pair -> System.out.printf("%35s %10s%n", pair.getKey(), pair.getValue()));
    }

    private static void zonedDateTime() {
        // represent a full date (year, month, day) and time (hour, minute, second, nanosecond) with a time zone (region/city, such as Europe/Paris).
        // Leaving from San Francisco on July 20, 2013, at 7:30 p.m.
        LocalDateTime leaving = LocalDateTime.of(2013, 7, 20, 19, 30);
        ZoneId leavingZone = ZoneId.of("America/Los_Angeles");
        ZonedDateTime departure = ZonedDateTime.of(leaving, leavingZone);

        // Flight is 10 hours and 50 minutes, or 650 minutes
        ZoneId arrivingZone = ZoneId.of("Asia/Tokyo");
        ZonedDateTime arrival = departure.withZoneSameInstant(arrivingZone).plusMinutes(650);
        // time-zone name
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm VV");
        // localized zone-offset
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm OOOO");
        System.out.printf("LEAVING:  %s(%s)%n", departure.format(format1), departure.format(format2));
        System.out.printf("ARRIVING: %s(%s)%n", arrival.format(format1), arrival.format(format2));
        // 夏令时
        if (arrivingZone.getRules().isDaylightSavings(arrival.toInstant())) {
            System.out.printf("(%s 夏令时生效)%n", arrivingZone);
        }else {
            System.out.printf("(%s 标准时间生效)%n", arrivingZone);
        }
    }

    private static void offsetDateTime() {
        // a full date (year, month, day) and time (hour, minute, second, nanosecond) with an offset from Greenwich/UTC time (+/-hours:minutes, such as +06:00 or -08:00)
        // The OffsetTime class, in effect, combines the LocalTime class with the ZoneOffset class. It is used to represent time (hour, minute, second, nanosecond) with an offset from Greenwich/UTC time (+/-hours:minutes, such as +06:00 or -08:00).
        // Find the last Thursday in July 2022.(+08:00)

        // 2022-05-01 12:00:00 +08:00的秒数，毫秒数
        LocalDateTime dt = LocalDateTime.of(2022, 5, 1, 12, 0);
        System.out.println(dt.toInstant(OffsetDateTime.now().getOffset()).toEpochMilli());
        System.out.println(OffsetDateTime.of(dt, ZoneOffset.of("+08:00")).toInstant().toEpochMilli());
        // 获取时区
        System.out.printf("当前时区: %s%n", OffsetDateTime.now().getOffset());
    }
}
