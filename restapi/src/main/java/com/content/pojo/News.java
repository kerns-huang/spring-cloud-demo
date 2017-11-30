package com.content.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * Created by huangchunbo on 2017/5/8.
 */
@ApiModel()
@Data
public class News  implements Serializable {
    @ApiModelProperty(value = "新闻主键")
    private Long id;
    @ApiModelProperty(value  = "新闻标题")
    private String title;
    @ApiModelProperty(value  = "新闻内容")
    private String content;
}
