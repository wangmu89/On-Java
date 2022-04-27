package com.wmirs.pl.java.java8.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Random;

/**
 * @Desc
 * @Author WangMu
 * @Create 2022-04-18
 */
public class BigDecimalExample {
    /*
     * BigDecimal represents an immutable arbitrary-precision signed decimal number.
     * - Unscaled value – an arbitrary precision integer
     * - Scale – a 32-bit integer representing the number of digits to the right of the decimal point
     * For example, the BigDecimal 3.14 has the unscaled value of 314 and the scale of 2.
     * ** USE **
     * - high-precision arithmetic
     * - calculations requiring control over scale and rounding off behavior
     * ***** calculations involving financial transactions. *****
     */

    public static void main(String[] args) {
        whenBigDecimalCreatedThenValueMatches();
        whenBigDecimalCreatedUsingValueOfThenValueMatches();
        whenGettingAttributesThenExpectedResult();
    }

    /**
     * create a BigDecimal object from String, character array, int, long, and BigInteger
     */
    public static void whenBigDecimalCreatedThenValueMatches() {
        BigDecimal bdFromString = new BigDecimal("0.1");
        BigDecimal bdFromChartArray = new BigDecimal(new char[]{'3', '.', '1', '4', '1', '5', '9', '2', '6'});
        BigDecimal bdFromInt = new BigDecimal(42);
        BigDecimal bdFromLong = new BigDecimal(123412345678901L);
        BigDecimal bdFromDouble1 = new BigDecimal(0.25d);
        BigDecimal bdFromDouble2 = new BigDecimal(0.33d);
        BigInteger bigInteger = BigInteger.probablePrime(100, new Random());
        BigDecimal bdFromBigInteger = new BigDecimal(bigInteger);

        System.out.println(Objects.equals("0.1", bdFromString.toString()));
        System.out.println(Objects.equals("3.1415926", bdFromChartArray.toString()));
        System.out.println(Objects.equals("42", bdFromInt.toString()));
        System.out.println(Objects.equals("123412345678901", bdFromLong.toString()));
        // false
        //  we should use the String constructor instead of the double constructor.
        System.out.println(bdFromDouble1.toString());
        System.out.println(bdFromDouble2.toString());
        System.out.println(Objects.equals("0.33", bdFromDouble2.toString()));
        System.out.println(Objects.equals(bigInteger.toString(), bdFromBigInteger.toString()));
    }

    public static void whenBigDecimalCreatedUsingValueOfThenValueMatches() {
        BigDecimal bdFromLong1 = BigDecimal.valueOf(123412345678901L);
        BigDecimal bdFromLong2 = BigDecimal.valueOf(123412345678901L, 2);
        BigDecimal bdFromDouble = BigDecimal.valueOf(0.1d);

        System.out.println(bdFromLong1);
        System.out.println(bdFromLong2);
        System.out.println(bdFromDouble);
    }

    public static void whenGettingAttributesThenExpectedResult() {
        // BigDecimal has methods to extract various attributes, such as precision, scale, and sign
        BigDecimal bd = new BigDecimal("-12345.6789");
        System.out.println(bd.precision());
        System.out.println(bd.scale());
        System.out.println(bd.signum());
        BigDecimal bd2 = new BigDecimal("123.456789");
        System.out.println(bd2.precision());
        System.out.println(bd2.scale());
        System.out.println(bd2.signum());
    }
}
