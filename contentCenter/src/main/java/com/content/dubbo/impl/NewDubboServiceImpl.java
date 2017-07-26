package com.content.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.content.dubbo.NewDubboService;
import com.content.pojo.News;
import com.content.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by huangchunbo on 2017/5/5.
 */
@Service(version = "1.0.0")
public class NewDubboServiceImpl implements NewDubboService {
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public String addNews(News news) {
        newsRepository.save(news);
        return "success";
    }

    public Iterable<News> findAll()
    {
       return newsRepository.findAll();
    }

}
