package com.content.controller;

import com.content.pojo.News;
import com.content.repository.NewsRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by kerns on 2017/4/13.
 */
@Controller
@RequestMapping(value = "/news")
@Api(value = "新闻", description = "新闻")
public class NewsController {
    @Autowired
    private NewsRepository newsRepository;

    @ApiOperation(value = "添加新闻信息", notes = "")
    @RequestMapping(value = "/addNews", method = RequestMethod.GET)
    @ResponseBody
    public String addNews(News news) {
        newsRepository.save(news);
        return "success";
    }

    @ApiOperation(value="查找所有新闻信息",notes = "新闻")
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public List<News> findAll() {
        return (List<News>) newsRepository.findAll();
    }

    @ApiOperation(value="分页查询新闻信息",notes = "新闻")
    @RequestMapping(value = "/findByPage", method = RequestMethod.GET)
    @ResponseBody
    public List<News> findByPage(PageRequest request){
        return (List<News>) newsRepository.findAll(request);
    }


}
