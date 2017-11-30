package com.zuul.filter;

import com.netflix.zuul.ZuulFilter;

/**
 * 接口的版本号控制
 *
 * @author huangchunbo
 * @version 1.0
 * @since 2017/11/28
 */
public class VersionFilter extends ZuulFilter {
    /**
     *过滤的类型
     *
     *@author huangchunbo
     *@since 2017/11/28
     *
     *@return
     */
    @Override
    public String filterType() {
        return null;
    }

    /**
     *过滤的顺序
     *
     *@author huangchunbo
     *@since 2017/11/28
     *
     *@return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否需要过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() {
        return null;
    }
}
