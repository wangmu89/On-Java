package com.wmirs.pl.java.base.domain.result;

/**
 * @Desc 带有长整数值的Result
 * @Author Wangmu
 * @Create 2019-12-10
 */
public class LongResult extends ComplexResult {
    /**
     * 长整数值
     */
    private final Long value;

    private LongResult(Result result, Long value) {
        super(result);
        this.value = value;
    }

    /**
     * 创建成功的LongResult, 并赋值
     *
     * @param value
     * @return
     */
    public static LongResult success(long value) {

        return of(Result.success(), value);
    }

    /**
     * 创建失败的LongResult
     *
     * @param result
     * @return
     */
    public static LongResult failure(Result result) {

        return of(result, null);
    }

    /**
     * 创建LongResult
     *
     * @param result
     * @param value
     * @return
     */
    public static LongResult of(Result result, Long value) {

        return new LongResult(result, value);
    }

    /**
     * 长整数值
     *
     * @return
     */
    public Long getValue() {

        return this.value;
    }

    /**
     * 长整数值，不存在则返回默认值
     *
     * @param def 默认值
     * @return
     */
    public long getValue(long def) {

        return this.value == null ? def : this.value;
    }

    @Override
    public String toString() {
        return  '{' +
                "result=" + result +
                ", value=" + value +
                '}';
    }
}
