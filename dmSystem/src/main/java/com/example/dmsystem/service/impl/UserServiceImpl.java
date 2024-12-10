package com.example.dmsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dmsystem.entity.User;
import com.example.dmsystem.mapper.UserMapper;
import com.example.dmsystem.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 这是用户表 服务实现类
 * </p>
 *
 * @author higashi
 * @since 2024-11-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage pageC(IPage<User> page) {
        return userMapper.pageC(page);
    }

    @Override
    public IPage PageCC(IPage<User> page, Wrapper<User> Wrapper) {

        return userMapper.pageCC(page, Wrapper);
    }

}
