package com.restapi.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.content.dubbo.NewDubboConsumerService;
import com.content.dubbo.NewDubboService;
import com.content.pojo.News;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huangchunbo on 2017/5/5.
 * 新闻管理类
 */
@Controller
@RequestMapping(value = "/new") // 通过这里配置使下面的映射都在/users下，可去除
@Api(value = "新闻", description = "新闻类数据操作")
public class NewController {
    @Autowired
    private NewDubboConsumerService newDubboConsumerService;
    @ApiOperation(value = "添加新闻信息", notes = "")
    @RequestMapping(value = "/addNews", method = RequestMethod.GET)
    @ResponseBody
    public String addNews(News news){
        return newDubboConsumerService.addNews(news);
    }

}


