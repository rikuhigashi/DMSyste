package com.example.dmsystem.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 这是用户表
 * </p>
 *
 * @author higashi
 * @since 2024-11-04
 */
@ApiModel(value = "User对象", description = "这是用户表")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户账号")
    private String useraccount;

    @ApiModelProperty("用户密码")
    private String userpassword;

    @ApiModelProperty("用户名字")
    private String username;

    @ApiModelProperty("0 管理员  1 普通用户")
    private Integer identity;


}
