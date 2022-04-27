package com.wmirs.pl.java.base.domain.result;

/**
 * @Desc 分页
 * @Author Wangmu
 * @Create 2019-09-29
 */
public final class Page {
    /**
     * 总量
     */
    private final int totalCount;

    /**
     * 总页数
     */
    private final int totalPage;

    /**
     * 当前页码
     */
    private final int pageNumber;

    /**
     * 每页数量
     */
    private final int pageSize;

    private Page(int totalCount, int totalPage, int pageNumber, int pageSize) {
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    /**
     * Create Page
     *
     * @param totalCount
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public static Page of(int totalCount, int pageNumber, int pageSize) {
        // 总页数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize + 1);
        return new Page(totalCount, totalPage, pageNumber, pageSize);
    }

    /**
     * 总量
     *
     * @return
     */
    public int getTotalCount() {

        return this.totalCount;
    }

    /**
     * 总页数
     *
     * @return
     */
    public int getTotalPage() {

        return this.totalPage;
    }

    /**
     * 当前页码
     *
     * @return
     */
    public int getPageNumber() {

        return this.pageNumber;
    }

    /**
     * 每页数量(最多返回)
     *
     * @return
     */
    public int getPageSize() {

        return this.pageSize;
    }

    /**
     * 是否最后一页
     *
     * @return
     */
    public boolean isLastPage() {

        return this.pageNumber >= this.totalPage;
    }

    @Override
    public String toString() {
        return  '{' +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                '}';
    }
}
