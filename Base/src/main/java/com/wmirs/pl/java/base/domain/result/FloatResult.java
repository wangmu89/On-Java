package com.wmirs.pl.java.base.domain.result;

/**
 * @Desc 带有浮点数值的Result
 * @Author Wangmu
 * @Create 2019-12-10
 */
public class FloatResult extends ComplexResult {
    /**
     * 浮点数值
     */
    private final Float value;

    private FloatResult(Result result, Float value) {
        super(result);
        this.value = value;
    }

    /**
     * 创建成功的FloatResult, 并赋值
     *
     * @param value
     * @return
     */
    public static FloatResult success(float value) {

        return of(Result.success(), value);
    }

    /**
     * 创建失败的FloatResult
     *
     * @param result
     * @return
     */
    public static FloatResult failure(Result result) {

        return of(result, null);
    }

    /**
     * 创建FloatResult
     * @param result
     * @param value
     * @return
     */
    public static FloatResult of(Result result, Float value) {

        return new FloatResult(result, value);
    }

    /**
     * 浮点数值
     *
     * @return
     */
    public Float getValue() {
        return this.value;
    }

    /**
     * 浮点数值，不存在，则返回默认值
     *
     * @param def 默认值
     * @return
     */
    public float getValue(float def) {

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
