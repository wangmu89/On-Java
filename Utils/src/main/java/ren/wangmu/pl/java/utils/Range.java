package ren.wangmu.pl.java.utils;

/**
 * @Desc
 * @Author WangMu
 * @Create 2022-04-15
 */
public interface Range {
    /**
     * 创建序列[startInclusive, ..., endExclusive), 按步长增加
     *
     * @param startInclusive 起始位置，包含
     * @param endExclusive   结束位置，不包含
     * @param step  步长，不能为0
     * @return
     */
    static int[] range(int startInclusive, int endExclusive, int step) {
        if(step == 0) {
            throw new IllegalArgumentException("步长[step]不能为0");
        }
        // 数组的长度
        int length = Math.max(0, step >= 0 ? (endExclusive + step - 1 - startInclusive) / step : (endExclusive + step + 1 - startInclusive) / step);
        int[] resArr = new int[length];
        for(int i = 0; i < length; i++) {
            resArr[i] = startInclusive + i * step;
        }
        return resArr;
    }

    /**
     * 创建序列[startInclusive, ..., endExclusive), 步长为1
     *
     * @param startInclusive 起始位置，包含
     * @param endExclusive   结束位置，不包含
     * @return
     */
    static int[] range(int startInclusive, int endExclusive) {

        return range(startInclusive, endExclusive, 1);
    }

    /**
     * 创建序列[0, ..., numExclusive), 步长为1
     *
     * @param numExclusive   结束位置，不包含
     * @return
     */
    static int[] range(int numExclusive) {

        return range(0, numExclusive);
    }
}
