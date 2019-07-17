package com.bfgy.cds.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * @Author liuzhiqiang
 * @Date 2019/7/15
 */
@Data
public class TestUser {

    private Integer id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("年龄")
    private Integer age;
    @ApiModelProperty("是否删除 0 未删除 1 已删除")
    private Integer isDel = 0;
}