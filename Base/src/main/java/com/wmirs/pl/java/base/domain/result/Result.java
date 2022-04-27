package com.wmirs.pl.java.base.domain.result;


/**
 * @Desc 标识成功与失败的Result
 * @Author Wangmu
 * @Create 2018-06-30
 */
public final class Result {
    /**
     * 成功的结果码(1)
     */
    public final static int SUCC_CODE = 1;
    /**
     * 错误的结果码(0)
     */
    public final static int FAIL_CODE = 0;

    /**
     * 结果码: 成功(1), 失败(0)
     */
    private final int code;
    /**
     * 错误详情: 如果成功, 则该字段为null; 如果失败, 则该字段不为null
     */
    private final Failure failure;

    private Result(int code, Failure failure) {
        this.code = code;
        this.failure = failure;
    }

    /**
     * 创建标识成功的Result
     *
     * @return
     */
    public static Result success() {

        return new Result(SUCC_CODE, null);
    }

    /**
     * 创建标识失败的Result
     *
     * @param failure 错误详情
     * @return
     */
    public static Result failure(Failure failure) {
        if(failure == null) {
            throw new IllegalArgumentException("Result为失败时，失败详情不能为空");
        }
        return new Result(FAIL_CODE, failure);
    }

    /**
     * 创建标识失败的Result
     *
     * @param failDesc 错误详情描述
     * @return
     */
    public static Result failure(String failDesc) {

        return failure(Failure.of(failDesc));
    }

    /**
     * 创建标识失败的Result
     *
     * @param throwable 异常栈
     * @return
     */
    public static Result failure(Throwable throwable) {

        return failure(Failure.of(throwable));
    }

    /**
     * Result是否成功
     *
     * @return
     */
    public boolean isSuccess() {

        return this.code == SUCC_CODE;
    }

    /**
     * Result是否失败
     *
     * @return
     */
    public boolean isFailure() {

        return this.code == FAIL_CODE;
    }

    /**
     * 获取结果码: 成功(1), 失败(0)
     *
     * @return
     */
    public int getCode() {

        return this.code;
    }

    /**
     * 获取错误详情, 如果成功, 则为空
     *
     * @return
     */
    public Failure getFailure() {

        return this.failure;
    }

    @Override
    public String toString() {
        return isSuccess() ? "Success" : "Failure: " + failure;
    }
}
