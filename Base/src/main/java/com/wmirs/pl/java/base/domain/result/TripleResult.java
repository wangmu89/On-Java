package com.wmirs.pl.java.base.domain.result;

/**
 * @Desc Triple Result
 * @Author Wangmu
 * @Create 2019-09-29
 */
public final class TripleResult <L, M, R> extends ComplexResult {
    /**
     * Left Value
     */
    private final L left;

    /**
     * Middle Value
     */
    private final M middle;

    /**
     * Right Value
     */
    private final R right;

    private TripleResult(Result result, L left, M middle, R right) {
        super(result);
        this.left = left;
        this.middle = middle;
        this.right = right;
    }

    /**
     * Success Triple Result
     *
     * @param left
     * @param middle
     * @param right
     * @param <L>
     * @param <M>
     * @param <R>
     * @return
     */
    public static <L, M, R> TripleResult<L, M, R> success(L left, M middle, R right) {

        return of(Result.success(), left, middle, right);
    }

    /**
     * Failure Triple Result
     *
     * @param result
     * @param <L>
     * @param <M>
     * @param <R>
     * @return
     */
    public static <L, M, R> TripleResult<L, M, R> failure(Result result) {

        return of(result, null, null, null);
    }

    /**
     * Create Triple Result
     *
     * @param result
     * @param left
     * @param middle
     * @param right
     * @param <L>
     * @param <M>
     * @param <R>
     * @return
     */
    public static <L, M, R> TripleResult<L, M, R> of(Result result, L left, M middle, R right) {

        return new TripleResult<>(result, left, middle, right);
    }

    /**
     * 左值
     *
     * @return
     */
    public L getLeft() {

        return this.left;
    }

    /**
     * 中间值
     *
     * @return
     */
    public M getMiddle() {

        return this.middle;
    }

    /**
     * 右值
     *
     * @return
     */
    public R getRight() {

        return this.right;
    }

    @Override
    public String toString() {
        return  '{' +
                "result=" + result +
                ", left=" + left +
                ", middle=" + middle +
                ", right=" + right +
                '}';
    }
}
