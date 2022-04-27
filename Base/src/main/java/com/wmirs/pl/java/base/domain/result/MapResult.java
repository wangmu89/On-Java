package com.wmirs.pl.java.base.domain.result;

import java.util.Collections;
import java.util.Map;

/**
 * @Desc 带有键值对的Result
 * @Author Wangmu
 * @Create 2018-06-30
 */
public final class MapResult<K, V> extends ComplexResult {
    /**
     * 键值对
     */
    private final Map<K, V> valueMap;

    private MapResult(Result result, Map<K, V> valueMap) {
        super(result);
        this.valueMap = valueMap;
    }

    /**
     * 创建成功的MapResult, 并赋值
     *
     * @param valueMap
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> MapResult<K, V> success(Map<K, V> valueMap) {

        return of(Result.success(), valueMap);
    }

    /**
     * 创建失败的MapResult
     *
     * @param result
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> MapResult<K, V> failure(Result result) {

        return of(result, null);
    }

    /**
     * 创建MapResult
     *
     * @param result
     * @param valueMap
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> MapResult<K, V> of(Result result, Map<K, V> valueMap) {

        return new MapResult<>(result, valueMap);
    }

    /**
     * 获取键值对
     *
     * @return
     */
    public Map<K, V> getValueMap() {

        return this.valueMap == null ? Collections.emptyMap() : this.valueMap;
    }

    /**
     * 容量
     *
     * @return
     */
    public int size() {

        return this.valueMap == null ? 0 : this.valueMap.size();
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {

        return this.valueMap == null || this.valueMap.isEmpty();
    }

    @Override
    public String toString() {
        return  '{' +
                "result=" + result +
                ", map=" + valueMap +
                '}';
    }
}
