package com.wmirs.pl.java.java8;

import java.util.Arrays;
import com.wmirs.pl.java.base.utils.Range;

/**
 * @Desc
 * @Author WangMu
 * @Create 2022-04-15
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Range.range(10)));

        System.out.println(Arrays.toString(Range.range(1, 10)));

        System.out.println(Arrays.toString(Range.range(1, 10, 2)));

        System.out.println(Arrays.toString(Range.range(1, 10, -2)));

        System.out.println(Arrays.toString(Range.range(10, 1, -2)));

        System.out.println(Arrays.toString(Range.range(-1, -10, -2)));

    }
}
