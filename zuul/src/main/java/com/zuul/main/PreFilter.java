/*
 * huiguan.com Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zuul.main;

import com.netflix.zuul.ZuulFilter;

/**
 *
 * @author huangchunbo
 * @since $$Revision:1.0.0, $$Date: 2017/10/9 17:06 $$
 */
public class PreFilter extends ZuulFilter {
    /**
     * 过滤器的类型
     *
     * @return
     */
    @Override
    public String filterType() {
        return null;
    }

    /**
     * 过滤的顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否可以被执行
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return false;
    }

    /**
     * 过滤链执行
     *
     * @return
     */
    @Override
    public Object run() {
        return null;
    }
}
