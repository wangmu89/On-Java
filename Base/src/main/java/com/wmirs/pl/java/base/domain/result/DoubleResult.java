package com.wmirs.pl.java.base.domain.result;

/**
 * @Desc 带有浮点数值的Result
 * @Author Wangmu
 * @Create 2019-12-10
 */
public class DoubleResult extends ComplexResult {
    /**
     * 浮点数值
     */
    private final Double value;

    private DoubleResult(Result result, Double value) {
        super(result);
        this.value = value;
    }

    /**
     * 创建成功的DoubleResult, 并赋值
     *
     * @param value
     * @return
     */
    public static DoubleResult success(double value) {

        return of(Result.success(), value);
    }

    /**
     * 创建失败的DoubleResult
     *
     * @param result
     * @return
     */
    public static DoubleResult failure(Result result) {

        return of(result, null);
    }

    /**
     * 创建DoubleResult
     *
     * @param result
     * @param value
     * @return
     */
    public static DoubleResult of(Result result, Double value) {

        return new DoubleResult(result, value);
    }

    /**
     * 浮点数值
     *
     * @return
     */
    public Double getValue() {

        return this.value;
    }

    /**
     * 浮点数值，如果为空，则返回默认值
     *
     * @param def 默认值
     * @return
     */
    public double getValue(double def) {

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
