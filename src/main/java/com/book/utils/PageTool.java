// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.book.utils;

import java.util.List;

public class PageTool<E> {
    private Integer pageSize;
    private Integer totalCount;
    private Integer totalPages;
    private Integer currentPage;
    private Integer prePage;
    private Integer nextPage;
    private Integer startIndex;
    private List<E> rows;

    public PageTool(Integer totalCount, String currentPage, String pageSize) {
        this.totalCount = totalCount;
        this.initCurrentPage(currentPage);
        this.initPageSize(pageSize);
        this.initTotalPages();
        this.initPrePage();
        this.initNextPage();
        this.initStartIndex();
    }

    private void initCurrentPage(String currentPage) {
        if (currentPage == null) {
            this.currentPage = 1;
        } else {
            this.currentPage = Integer.valueOf(currentPage);
        }

    }

    private void initPageSize(String pageSize) {
        if (pageSize == null) {
            this.pageSize = 5;
        } else {
            this.pageSize = Integer.valueOf(pageSize);
        }

    }

    private void initTotalPages() {
        this.totalPages = this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize : this.totalCount / this.pageSize + 1;
    }

    private void initPrePage() {
        if (this.currentPage == 1) {
            this.prePage = 1;
        } else {
            this.prePage = this.currentPage - 1;
        }

    }

    private void initNextPage() {
        if (this.currentPage == this.totalPages) {
            this.nextPage = this.totalPages;
        } else {
            this.nextPage = this.currentPage + 1;
        }

    }

    private void initStartIndex() {
        this.startIndex = this.pageSize * (this.currentPage - 1);
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPrePage() {
        return this.prePage;
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }

    public Integer getNextPage() {
        return this.nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getStartIndex() {
        return this.startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public List<E> getRows() {
        return this.rows;
    }

    public void setRows(List<E> rows) {
        this.rows = rows;
    }

    public String toString() {
        return "PageTool [pageSize=" + this.pageSize + ", totalCount=" + this.totalCount + ", totalPages=" + this.totalPages + ", currentPage=" + this.currentPage + ", prePage=" + this.prePage + ", nextPage=" + this.nextPage + ", startIndex=" + this.startIndex + ", rows=" + this.rows + "]";
    }
}
