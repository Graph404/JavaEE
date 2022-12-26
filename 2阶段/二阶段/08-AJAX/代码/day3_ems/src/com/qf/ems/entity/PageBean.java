package com.qf.ems.entity;

import lombok.Data;

import java.util.List;

@Data
public class PageBean {
    public static final int PAGE_SIZE = 5;
    private int first; // 第一页
    private long last; // 最后一页
    private long pages; // 页数
    private long count; // 条数
    private long prev; // 上一页
    private long next; // 下一页
    private long [] numbers; // 中间显示多个点击页
    private long current; // 当前页
    private boolean isFirst; // 是否首页
    private boolean isLast; // 是否尾页
    private boolean hasPrev; // 是否有上一页
    private boolean hasNext; // 是否有下一页
    private List list; // 当前页的数据

    public boolean getIsFirst(){
        return this.isFirst;
    }

    public boolean getIsLast(){
        return this.isLast;
    }

    public PageBean(long count, long current, List list){
        this.count = count;
        this.current = current;
        this.list = list;
        // 计算其他的值
        this.first = 1;
        // 计算页数
        this.pages = count % PAGE_SIZE == 0 ? count / PAGE_SIZE : count / PAGE_SIZE + 1;
        this.last = this.pages;
        this.prev = this.current - 1;
        this.next = this.current + 1;
        this.isFirst = current == 1;
        this.isLast = current == pages;
        this.hasPrev = current > 1;
        this.hasNext = current < pages;

        // 最前面页数
        long start = this.current > 4 ? this.current - 4 : 1;
        // 最后面页数
        long end = this.pages - this.current >= 4 ? this.current + 4 : this.pages;
        this.numbers = new long[(int) (end - start + 1)];
        for (int i = 0; i<numbers.length; i++){
            this.numbers[i] = start + i;
        }
    }
}
