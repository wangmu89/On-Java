package ren.wangmu.pl.java.java8.math;

import java.math.BigInteger;

/**
 * @Desc
 * @Author WangMu
 * @Create 2022-04-18
 */
public class BigIntegerExample {
    // widely used in security and cryptography applications.

    public static void main(String[] args) {
        createdFromConstructor();

        convertedFromValueOf();

        arithmeticLogicalOperation();

        compared();
    }

    public static void createdFromConstructor() {
        // 50!
        BigInteger biFromString = new BigInteger("30414093201713378043612608166064768844377641568960512000000000000");

        BigInteger biFromByteArray = new BigInteger(new byte[]{64, 64, 64, 64, 64, 64});

        BigInteger biFromSignMagnitude = new BigInteger(-1, new byte[]{64, 64, 64, 64, 64, 64});

        System.out.println(biFromString);
        System.out.println(biFromByteArray);
        System.out.println(biFromSignMagnitude);

        // 01000000
        System.out.println(new BigInteger(new byte[]{64}));
        // 01000000,01000000
        System.out.println(new BigInteger(new byte[]{64, 64}));
        System.out.println(new BigInteger(new byte[]{64, 64, 64}));
        System.out.println(new BigInteger(new byte[]{64, 64, 64, 64}));
        System.out.println(new BigInteger(new byte[]{64, 64, 64, 64, 64}));
        System.out.println(new BigInteger(new byte[]{64, 64, 64, 64, 64, 64}));
    }

    public static void convertedFromValueOf() {
        BigInteger biFromLong = BigInteger.valueOf(2305843009213693951L);
        System.out.println(biFromLong);
    }

    public static void arithmeticLogicalOperation() {
        BigInteger bi1 = new BigInteger("123456789012345678901234567890");
        BigInteger bi2 = new BigInteger("123456789012345678901234567891");
        // + - × ÷
        System.out.println(bi1.add(bi2));
        System.out.println(bi1.subtract(bi2));
        System.out.println(bi1.multiply(bi2));
        System.out.println(bi1.divide(BigInteger.valueOf(2)));
        // and or
        System.out.println(BigInteger.valueOf(1).and(BigInteger.valueOf(1)));
        System.out.println(BigInteger.valueOf(1).and(BigInteger.valueOf(0)));
        System.out.println(BigInteger.valueOf(0).and(BigInteger.valueOf(1)));
        System.out.println(BigInteger.valueOf(0).and(BigInteger.valueOf(0)));
        System.out.println(BigInteger.valueOf(1).or(BigInteger.valueOf(1)));
        System.out.println(BigInteger.valueOf(1).or(BigInteger.valueOf(0)));
        System.out.println(BigInteger.valueOf(0).or(BigInteger.valueOf(1)));
        System.out.println(BigInteger.valueOf(0).or(BigInteger.valueOf(0)));
        System.out.println(BigInteger.valueOf(1).negate());
        System.out.println(BigInteger.valueOf(0).negate());

    }

    public static void compared() {
        BigInteger bi1 = new BigInteger("123456789012345678901234567890");
        BigInteger bi2 = new BigInteger("123456789012345678901234567891");
        BigInteger bi3 = new BigInteger("123456789012345678901234567892");

        System.out.println(bi1.compareTo(bi2));
        System.out.println(bi1.compareTo(bi3));
        System.out.println(bi3.compareTo(bi2));
        System.out.println(bi3.compareTo(new BigInteger("123456789012345678901234567892")));
    }
}
