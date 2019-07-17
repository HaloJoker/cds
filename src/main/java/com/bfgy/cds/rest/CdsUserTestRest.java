package com.bfgy.cds.rest;

import com.bfgy.cds.common.utils.ResultDataDto;
import com.bfgy.cds.entity.TestUser;
import com.bfgy.cds.service.CdsTestUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liuzhiqiang
 * @Date 2019/7/15
 */
@Api(description = "swagger testUser测试")
@RestController
@RequestMapping("/testUser")
public class CdsUserTestRest {

    @Autowired
    private CdsTestUserService userService;

    @ApiOperation("testUser测试  add方法")
    @PostMapping("/add")
    public ResultDataDto addTestUser(@RequestBody TestUser user){
        userService.add(user);
        return ResultDataDto.ok();
    }
}
