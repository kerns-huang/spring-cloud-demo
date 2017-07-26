package com.content.dubbo;

import com.content.pojo.News;

/**
 * Created by huangchunbo on 2017/5/5.
 */
public interface NewDubboService {
    String addNews(News news);
    Iterable<News> findAll();
}
