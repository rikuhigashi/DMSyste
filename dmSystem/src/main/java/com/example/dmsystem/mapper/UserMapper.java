package com.example.dmsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.dmsystem.entity.User;

/**
 * <p>
 * 这是用户表 Mapper 接口
 * </p>
 *
 * @author higashi
 * @since 2024-11-04
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    IPage pageC(IPage<User> page);
    public IPage pageCC(IPage<User> page, @Param(Constants.WRAPPER) Wrapper<User> wrapper);

}
