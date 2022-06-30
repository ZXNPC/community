package com.example.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO<T> {
    private List<T> data;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        // 页面总数
        Integer totalPage = 0;
        if(totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        this.totalPage = totalPage;

        // 当前页面
        if (page < 1)
            page = 1;
        if (page > totalPage)
            page = totalPage;
        this.page = page;


        // 页面显示
        if(totalPage <= 7) {
            for (Integer i = 1; i <= totalPage; i++)
                pages.add(i);
        } else {
            Integer start;
            if(page <= 4) {
                start = 1;
            }
            else if (totalPage - page <= 2) {
                start = totalPage - 6;
            }
            else {
                start = page - 3;
            }
            for (Integer i = start; i<=start+6; i++)
                pages.add(i);
        }

        // 是否展示上一页
        if(page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        // 是否展示下一页
        if(page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }

        // 是否展示第一页
        if(pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }

        // 是否展示最后一页
        if(pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }


    }
}
