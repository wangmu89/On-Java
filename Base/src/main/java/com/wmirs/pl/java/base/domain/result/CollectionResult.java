package com.wmirs.pl.java.base.domain.result;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Desc 带有集合的Result
 * @Author Wangmu
 * @Create 2018-06-30
 */
public class CollectionResult<T> extends ComplexResult {
    /**
     * 数据集
     */
    protected Collection<T> values;

    protected CollectionResult(Result result, Collection<T> values) {
        super(result);
        this.values = values;
    }

    /**
     * 创建成功的CollectionResult, 并赋单个值
     *
     * @param value
     * @param <T>
     * @return
     */
    public static <T> CollectionResult<T> success(T value) {

        return success(Collections.singletonList(value));
    }

    /**
     * 创建成功的CollectionResult, 并赋值
     *
     * @param coll
     * @param <T>
     * @return
     */
    public static <T> CollectionResult<T> success(Collection<T> coll) {

        return of(Result.success(), coll);
    }

    /**
     * 创建失败的CollectionResult
     *
     * @param result
     * @param <T>
     * @return
     */
    public static <T> CollectionResult<T> failure(Result result) {

        return of(result, Collections.emptyList());
    }

    /**
     * 创建CollectionResult
     *
     * @param result
     * @param value
     * @param <T>
     * @return
     */
    public static <T> CollectionResult<T> of(Result result, T value) {

        return of(result, Collections.singletonList(value));
    }

    /**
     * 创建CollectionResult
     *
     * @param result
     * @param coll
     * @param <T>
     * @return
     */
    public static <T> CollectionResult<T> of(Result result, Collection<T> coll) {

        return new CollectionResult<>(result, coll);
    }

    /**
     * 返回结果集
     *
     * @return
     */
    public Collection<T> getValues() {

        return this.values == null ? Collections.emptyList() : this.values;
    }

    /**
     * 将集合以List的方式返回
     *
     * @return
     */
    public List<T> getValueAsList() {

        return this.values == null ? Collections.emptyList() : new ArrayList<>(this.values);
    }

    /**
     * 将集合以Set的方式返回
     *
     * @return
     */
    public Set<T> getValueAsSet() {

        return this.values == null ? Collections.emptySet() : new HashSet<>(this.values);
    }

    /**
     * 容量
     *
     * @return
     */
    public int size() {

        return this.values == null ? 0 : this.values.size();
    }

    /**
     * 是否不包含任何元素
     *
     * @return
     */
    public boolean isEmpty() {

        return this.values == null || this.values.isEmpty();
    }

    @Override
    public String toString() {
        return  '{' +
                "result=" + result +
                ", collection=" + values +
                '}';
    }
}
