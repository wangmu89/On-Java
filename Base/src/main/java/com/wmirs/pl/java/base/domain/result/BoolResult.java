package com.wmirs.pl.java.base.domain.result;

/**
 * @Desc 带有boolean值的Result
 * @Author Wangmu
 * @Create 2019-12-10
 */
public class BoolResult extends ComplexResult {
    /**
     * 布尔值
     */
    private final Boolean value;

    private BoolResult(Result result, Boolean value) {
        super(result);
        this.value = value;
    }

    /**
     * 创建成功的BoolResult, 并赋值
     *
     * @param value
     * @return
     */
    public static BoolResult success(boolean value) {

        return of(Result.success(), value);
    }

    /**
     * 创建失败的BoolResult
     *
     * @param result
     * @return
     */
    public static BoolResult failure(Result result) {

        return of(result, null);
    }

    /**
     * 创建BoolResult
     *
     * @param result
     * @param value
     * @return
     */
    public static BoolResult of(Result result, Boolean value) {

        return new BoolResult(result, value);
    }

    /**
     * 获取boolean值
     *
     * @return
     */
    public Boolean getValue() {

        return this.value;
    }

    /**
     * 布尔值，不存在则返回默认值
     *
     * @param def 默认值
     * @return
     */
    public boolean getValue(boolean def) {

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
