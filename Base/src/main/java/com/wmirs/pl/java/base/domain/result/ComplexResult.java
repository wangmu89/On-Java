package com.wmirs.pl.java.base.domain.result;

/**
 * @Desc 集成Result的复合Result
 * @Author Wangmu
 * @Create 2019-05-21
 */
public abstract class ComplexResult {
    /**
     * Result
     */
    protected final Result result;

    protected ComplexResult(Result result) {
        if(result == null) {
            throw new IllegalArgumentException("表示成功或失败的Result，不能为空");
        }
        this.result = result;
    }

    /**
     * 获取Result
     *
     * @return
     */
    public Result getResult() {

        return this.result;
    }

    /**
     * 是否成功
     *
     * @return
     */
    public boolean isSuccess() {

        return result.isSuccess();
    }

    /**
     * 是否失败
     *
     * @return
     */
    public boolean isFailure() {

        return result.isFailure();
    }
}
