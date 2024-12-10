package com.example.dmsystem.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.dmsystem.entity.User;

/**
 * <p>
 * 这是用户表 服务类
 * </p>
 *
 * @author higashi
 * @since 2024-11-04
 */
public interface IUserService extends IService<User> {

    public IPage pageC(IPage<User> page);

    public IPage PageCC(IPage<User> page, Wrapper<User> Wrapper);

}
