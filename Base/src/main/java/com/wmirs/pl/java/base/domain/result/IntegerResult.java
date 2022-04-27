package com.wmirs.pl.java.base.domain.result;

/**
 * @Desc 带有整数值的Result
 * @Author Wangmu
 * @Create 2019-12-10
 */
public class IntegerResult extends ComplexResult {
    /**
     * 整数值
     */
    private final Integer value;

    private IntegerResult(Result result, Integer value) {
        super(result);
        this.value = value;
    }

    /**
     * 创建成功的IntegerResult, 并赋值
     *
     * @param value
     * @return
     */
    public static IntegerResult success(int value) {

        return of(Result.success(), value);
    }

    /**
     * 创建失败的IntegerResult
     *
     * @param result
     * @return
     */
    public static IntegerResult failure(Result result) {

        return of(result, null);
    }

    /**
     * 创建IntegerResult
     *
     * @param result
     * @param value
     * @return
     */
    public static IntegerResult of(Result result, Integer value) {

        return new IntegerResult(result, value);
    }

    /**
     * 获取整数值
     *
     * @return
     */
    public Integer getValue() {

        return this.value;
    }

    /**
     * 整数值，不存在则返回默认值
     *
     * @param def 默认值
     * @return
     */
    public int getValue(int def) {

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
