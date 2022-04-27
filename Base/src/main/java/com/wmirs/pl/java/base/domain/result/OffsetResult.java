package com.wmirs.pl.java.base.domain.result;

import java.util.Collection;
import java.util.Collections;

/**
 * @Desc Offset Result
 * @Author Wangmu
 * @Create 2019-01-14
 */
public final class OffsetResult<T> extends CollectionResult<T> {
    /**
     * 偏移信息
     */
    private final Offset offset;

    private OffsetResult(Result result, Offset offset, Collection<T> values) {
        super(result, values);
        this.offset = offset;
    }

    /**
     * Success Offset Result
     *
     * @param offset
     * @param values
     * @param <T>
     * @return
     */
    public static <T> OffsetResult<T> success(Offset offset, Collection<T> values) {

        return of(Result.success(), offset, values);
    }

    /**
     * Failure Offset Result
     * @param result
     * @param <T>
     * @return
     */
    public static <T> OffsetResult<T> failure(Result result) {

        return failure(result, null);
    }

    /**
     * Failure Offset Result
     * @param result
     * @param offset
     * @param <T>
     * @return
     */
    public static <T> OffsetResult<T> failure(Result result, Offset offset) {

        return of(result, offset, Collections.emptyList());
    }

    /**
     * Create Offset Result
     * @param result
     * @param offset
     * @param values
     * @param <T>
     * @return
     */
    public static <T> OffsetResult<T> of(Result result, Offset offset, Collection<T> values) {

        return new OffsetResult<>(result, offset, values);
    }

    /**
     * 偏移量
     *
     * @return
     */
    public Offset getOffset() {

        return offset;
    }

    @Override
    public String toString() {
        return  '{' +
                "result=" + result +
                ", offset=" + offset +
                ", values=" + values +
                '}';
    }
}
