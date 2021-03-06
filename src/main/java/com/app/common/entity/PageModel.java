package com.app.common.entity;

import com.app.common.util.BeanUtils;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

/**
 * 分页实体，包含分页相关信息
 * @param <T>
 */
public class PageModel<T> {
    private static final long serialVersionUID = -4426958360243585882L;

    public static final int PAGENUM = 1;
    public static final int PAGESIZE = 9;

    private int pageNum;

    private long pageSize;

    private long total;

    private int pages;

    private List<T> list;

    public PageModel() {
        this.setPageNum(PAGENUM);
        this.setPageSize(PAGESIZE);
    }

    public PageModel(int pageNum, int pageSize) {
        this.setPageNum(pageNum);
        this.setPageSize(pageSize);
    }

    public static <T> PageModel<T> build(Page<T> page, Map<String, String> params) {
        PageModel<T> pageModel = new PageModel<>();
        BeanUtils.copyProperties(page.toPageInfo(), pageModel);
        pageModel.setList(page.toPageInfo().getList());
        pageModel.setPageNum(Integer.valueOf(params.get("pageNum")==null?"1":params.get("pageNum")));
        pageModel.setPageSize(Integer.valueOf(params.get("pageSize")==null?"10":params.get("pageSize")));
        return pageModel;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    /**
     * 页数
     * @return
     */
    public long getPages() {
        return total%pageSize==0?total/pageSize:((total/pageSize)+1);
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
