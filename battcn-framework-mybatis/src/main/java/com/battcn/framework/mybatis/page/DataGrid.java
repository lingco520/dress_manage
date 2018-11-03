package com.battcn.framework.mybatis.page;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tk.mybatis.mapper.util.StringUtil;
import tk.mybatis.orderbyhelper.OrderByHelper;

/**
 * 分页对象
 *
 * @author Levin
 * @version 2.5.1
 * @since 2018-01-10
 */
public class DataGrid {

    private int pageSize = 10;
    private int pageNum = 1;
    private String sort;
    private String order = " desc";

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void getOrderBy() {
        OrderByHelper.orderBy(StringUtil.isEmpty(sort) ? null : humpToLine(sort) + " " + order);
    }

    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }


}
