package com.restapi.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *用户信息
 *
 *@author huangchunbo
 *@since 2017/11/28
 *
 *@return
 */
@ApiModel
@Data
public class User implements Serializable {
    @ApiModelProperty(value = "用户的Id", required = true)
    private Long id;
    //姓名
    @ApiModelProperty(value = "用户姓名", required = true)
    private String name;
    //年龄
    @ApiModelProperty(value = "用户年龄", required = true)
    private Integer age;
}
