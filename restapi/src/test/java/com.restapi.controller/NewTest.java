/*
 * huiguan.com Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.restapi.controller;

import com.content.pojo.News;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author huangchunbo
 * @since $$Revision:1.0.0, $$Date: 2017/10/10 13:45 $$
 */
public class NewTest extends BaseTemplateTestCase{

    @Autowired
    private NewController newController;
    @Test
    public void test()
    {
        News news=new News();
        news.setContent("test");
        news.setTitle("213123123");
        newController.addNews(news);
    }

}
