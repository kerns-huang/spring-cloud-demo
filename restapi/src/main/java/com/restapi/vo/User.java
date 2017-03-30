package com.restapi.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by kerns on 2017/3/23.
 */
@ApiModel
public class User implements Serializable {
    @ApiModelProperty(value = "用户的Id", required = true)
    private Long id;
    @ApiModelProperty(value = "用户姓名", required = true)
    private String name;//姓名
    @ApiModelProperty(value = "用户年龄", required = true)
    private Integer age;//年龄

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
