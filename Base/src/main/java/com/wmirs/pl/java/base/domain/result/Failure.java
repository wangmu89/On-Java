package com.wmirs.pl.java.base.domain.result;

import org.apache.commons.lang3.StringUtils;

/**
 * @Desc 错误详情, 包括: 错误码, 错误名称, 错误详情, 异常或者错误堆栈信息
 * @Author Wangmu
 * @Create 2018-06-30
 */
public final class Failure {
    /**
     * 异常错误码
     */
    private static final int THROWABLE_FAIL_CODE = -500;
    /**
     * 默认错误码
     */
    private static final int DEFAULT_FAIL_CODE = -1;
    /**
     * 异常错误名称
     */
    private static final String DEFAULT_FAIL_NAME = "Server.Error.Internal";

    /**
     * 错误码
     */
    private final int code;
    /**
     * 错误名称
     */
    private final String name;
    /**
     * 错误详情
     */
    private final String desc;
    /**
     * 异常栈
     */
    private final Throwable throwable;

    private Failure(int code, String name, String desc, Throwable throwable) {
        if(StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("[错误详情名称]不能为空");
        }
        if(StringUtils.isBlank(desc)) {
            throw new IllegalArgumentException("[错误详情描述]不能为空");
        }
        this.code = code;
        this.name = name;
        this.desc = desc;
        this.throwable = throwable;
    }

    /**
     * 创建错误详情
     *
     * @param throwable 异常栈信息
     * @return
     */
    public static Failure of(Throwable throwable) {

        return of(THROWABLE_FAIL_CODE, throwable.getClass().getSimpleName(), throwable.getMessage(), throwable);
    }

    /**
     * 创建错误详情
     *
     * @param desc 错误详情
     * @return
     */
    public static Failure of(String desc) {

        return of(DEFAULT_FAIL_CODE, DEFAULT_FAIL_NAME, desc, null);
    }

    /**
     * 创建错误详情
     *
     * @param code 错误码
     * @param name 错误名称
     * @param desc 错误详情
     * @return
     */
    public static Failure of(int code, String name, String desc) {

        return of(code, name, desc, null);
    }

    /**
     * 创建错误详情
     *
     * @param code 错误码
     * @param name 错误名称
     * @param desc 错误详情
     * @param throwable 异常栈信息
     * @return
     */
    public static Failure of(int code, String name, String desc, Throwable throwable) {

        return new Failure(code, name, desc, throwable);
    }

    /**
     * 错误码
     *
     * @return
     */
    public int getCode() {
        return this.code;
    }

    /**
     * 错误名称
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * 错误描述
     *
     * @return
     */
    public String getDesc() {
        return this.desc;
    }

    /**
     * 异常栈
     *
     * @return
     */
    public Throwable getThrowable() {
        return this.throwable;
    }

    @Override
    public String toString() {
        return "Failure{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", throwable=" + throwable +
                '}';
    }
}
