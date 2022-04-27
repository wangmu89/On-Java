package com.wmirs.pl.java.base.domain.result;

/**
 * @Desc 带有字符值的Result
 * @Author Mushen
 * @Create 2019-12-10
 */
public class CharResult extends ComplexResult {
    /**
     * 字符值
     */
    private final Character value;

    private CharResult(Result result, Character value) {
        super(result);
        this.value = value;
    }

    /**
     * 创建成功的CharResult, 并赋值
     *
     * @param value
     * @return
     */
    public static CharResult success(char value) {

        return of(Result.success(), value);
    }

    /**
     * 创建失败的CharResult
     *
     * @param result
     * @return
     */
    public static CharResult failure(Result result) {

        return of(result, null);
    }

    /**
     * 创建CharResult
     *
     * @param result
     * @param value
     * @return
     */
    public static CharResult of(Result result, Character value) {

        return new CharResult(result, value);
    }

    /**
     * 字符值
     *
     * @return
     */
    public Character getValue() {

        return this.value;
    }

    /**
     * 字符值，不存在，则返回默认值
     *
     * @return
     */
    public char getValue(char def) {

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
