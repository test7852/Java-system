package com.ht.util;

/**
 * @author lrq
 * @date 2020/6/9 9:12
 * 分页
 */
public class Pager {

    public int currPage = 1;//当前页
    public int pageSize = 8;//每页行数
    public int totalRow = 0;//总行数
    public int totalPage = 0;//总页数
    public Object data;//每页数据

    public void page(int row) {
        totalRow = row;
        //计算总页数
        totalPage = (totalRow + pageSize - 1) / pageSize;
        //判断当前页的上限和下限
        if (currPage < 1) {
            currPage = 1;
        }
        if (currPage > totalPage && totalPage != 0) {
            currPage = totalPage;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

}
