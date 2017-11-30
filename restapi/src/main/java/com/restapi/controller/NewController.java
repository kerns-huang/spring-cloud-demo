package com.restapi.controller;

import com.content.pojo.News;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huangchunbo on 2017/5/5.
 * 新闻管理类
 */
@Controller
@RequestMapping(value = "/new") // 通过这里配置使下面的映射都在/users下，可去除
@RestController
@Api(value = "新闻", description = "新闻类数据操作")
public class NewController {
    @ApiOperation(value = "添加新闻信息", notes = "新闻列表")
    @RequestMapping(value = "/addNews", method = RequestMethod.GET)
    @ResponseBody
    public String addNews(News news){
        return null;
    }
    @ApiOperation(value = "获取新闻列表", notes = "新闻列表")
    @RequestMapping(value = "/findAllNews", method = RequestMethod.GET)
    @ResponseBody
    @ApiResponses(@ApiResponse(code = 200, message ="消息" ,response=Iterable.class))
    public Iterable<News> findAllNews(){
        return null;
    }

}


