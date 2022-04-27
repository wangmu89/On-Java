package com.wmirs.pl.java.base.domain.result;

/**
 * @Desc 偏移
 * @Author Wangmu
 * @Create 2019-09-29
 */
public final class Offset {
    /**
     * 总量
     */
    private final int total;

    /**
     * 偏移位置, 从0开始
     */
    private final int from;

    /**
     * 大小, 从偏移位置获取size元素, 大于0
     */
    private final int size;

    private Offset(int total, int from, int size) {
        this.total = total;
        this.from = from;
        this.size = size;
    }

    /**
     * Create Offset
     *
     * @param total
     * @param from
     * @param size
     * @return
     */
    public static Offset of(int total, int from, int size) {

        return new Offset(total, from, size);
    }

    /**
     * 总量
     *
     * @return
     */
    public int getTotal() {

        return this.total;
    }

    /**
     * 偏移量
     *
     * @return
     */
    public int getFrom() {

        return this.from;
    }

    /**
     * 数量(最多返回)
     *
     * @return
     */
    public int getSize() {

        return this.size;
    }

    @Override
    public String toString() {
        return  '{' +
                "total=" + total +
                ", from=" + from +
                ", size=" + size +
                '}';
    }
}
