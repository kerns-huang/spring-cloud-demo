package com.restapi.controller;

import com.restapi.vo.UserVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kerns on 2017/3/23.
 */
@RestController
@RequestMapping(value = "/user")//通过这里配置使下面的映射都在/users下
public class TestController {

    @ApiOperation(value = "获取测试数据集", notes = "")
    @RequestMapping(value = "/getUserList")
    public List<UserVO> getUserList() {
        return new ArrayList<UserVO>();
    }

    @ApiOperation(value = "创建用户", notes = "根据user对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String createUser(@RequestBody UserVO userVO) {
        return "success";
    }

    @ApiOperation(value = "获取用户", notes = "根据url的id来获取用户的详细信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public UserVO getUser(@PathVariable Long id) {
        return null;
    }


}
