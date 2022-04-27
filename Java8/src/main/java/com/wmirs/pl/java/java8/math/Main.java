package com.wmirs.pl.java.java8.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Currency;

/**
 * @Desc
 * @Author WangMu
 * @Create 2022-04-18
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.of(2022, 4, 16, 4, 10, 0).plusDays(14));


        double x = 0.0;
        for(int i = 0; i < 10; i++) {
            x += 0.1;
        }
        System.out.println(x);
        double y = 0.0;
        for(int i = 0; i < 4; i++) {
            y += 0.25;
        }
        System.out.println(y);



        System.out.println(x == 1.0);

        System.out.println(Math.pow(10, 0));
        System.out.println(Math.pow(10, 1));
        System.out.println(Math.pow(10, 2));
        System.out.println(Math.pow(10, 3));

        System.out.println(BigInteger.valueOf(10).pow(0));
        System.out.println(BigInteger.valueOf(10).pow(1));
        System.out.println(BigInteger.valueOf(10).pow(2));
        System.out.println(BigInteger.valueOf(10).pow(3));

        System.out.println(
                BigInteger.valueOf(Math.round(100.0950 * Math.pow(10, 2)))
        );

        System.out.println(Currency.getInstance("CNY").getDisplayName());
        System.out.println(Currency.getInstance("USD").getDisplayName());
        System.out.println(Currency.getInstance("JPY").getDisplayName());

        System.out.println(
                new BigDecimal(new BigInteger("10009")).multiply(BigDecimal.valueOf(3.7))
                        .setScale(0, BigDecimal.ROUND_HALF_EVEN).toBigInteger()
        );

        System.out.println(
                BigInteger.valueOf(10).divide(BigInteger.valueOf(3))
        );

        BigInteger bi1 = BigInteger.valueOf(100);
        BigInteger bi2 = bi1;
        bi2 = bi2.multiply(BigInteger.valueOf(100));
        System.out.println(bi1);
        System.out.println(bi2);
    }
}
