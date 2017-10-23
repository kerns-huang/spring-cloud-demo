package com.content.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by huangchunbo on 2017/5/8.
 */
@ApiModel()
public class News  implements Serializable {
    @ApiModelProperty(value = "新闻主键")
    private Long id;
    @ApiModelProperty(value  = "新闻标题")
    private String title;//标题
    @ApiModelProperty(value  = "新闻内容")
    private String content;//内容

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }
}
