package com.content.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.content.pojo.News;
import org.springframework.stereotype.Component;

/**
 * Created by huangchunbo on 2017/5/12.
 * 为什么一定要加入这个类，才能读取到远程的service类？
 */
@Component
public class NewDubboConsumerService
{
    @Reference(version = "1.0.0")
    private NewDubboService newDubboService;

    public void test()
    {
        News news=new News();
        news.setContent("tessfdafds");
        news.setTitle("1231");
        news.setId(123l);
        newDubboService.addNews(news);
    }

    public String addNews(News news)
    {
        return newDubboService.addNews(news);
    }
    public Iterable<News> findAll()
    {
        return newDubboService.findAll();
    }
}
