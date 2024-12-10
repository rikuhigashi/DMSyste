package com.example.dmsystem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dmsystem.common.QueryPageParam;
import com.example.dmsystem.common.Result;
import com.example.dmsystem.entity.User;
import com.example.dmsystem.service.IUserService;

/**
 * <p>
 * 这是用户表 前端控制器
 * </p>
 *
 * @author higashi
 * @since 2024-11-04
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/list")
    public List<User> list() {
        return iUserService.list();
    }

    //增加
    @PostMapping("/add")
    public Result add(@RequestBody User user) {
        return iUserService.save(user)?Result.suc():Result.fail();
    }

    //修改
    @PostMapping("/remove")
    public boolean mod(@RequestBody User user) {
        return iUserService.updateById(user);
    }

    // 添加或修改
    @PostMapping("/addOrRemove")
    public boolean addOrRemove(@RequestBody User user) {
        return iUserService.saveOrUpdate(user);
    }

    //删除
    @GetMapping("/delete")
    public boolean delect(Integer id) {
        return iUserService.removeById(id);
    }

    //登录
    @PostMapping("/login")
    public Result login(@RequestBody User user) {

        System.out.println("account:" + user.getUseraccount() +"-------"+ "password:" + user.getUserpassword());

        List list = iUserService.lambdaQuery()
                .eq(User::getUseraccount, user.getUseraccount())
                .eq(User::getUserpassword, user.getUserpassword())
                .list();
        return list.size() > 0 ? Result.suc() : Result.fail();
    }

    // 通过名字查找
    @PostMapping("/listP")
    public List<User> listP(@RequestBody User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getUsername, user.getUsername());
        return iUserService.list(lambdaQueryWrapper);
    }

    //自定义分页大小，以及使用分页
    // 使用MyBatis-Plus
    @PostMapping("/listPage")
    public List<User> listPage(@RequestBody QueryPageParam qParam) {
        System.out.println(qParam);

        // 获取定义的param
        HashMap param = qParam.getParam();
        String name = (String) param.get("username");

        // 分页设置
        Page<User> page = new Page<>();
        // 设置当前页
        page.setCurrent(qParam.getPageNum());
        // 设置页面大小
        page.setSize(qParam.getPageSize());

        // 查询
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getUsername, name);

        // 使用分页
        // page(page, lambdaQueryWrapper); ------把page的大小以及值传给分页
        IPage result = iUserService.page(page, lambdaQueryWrapper);
        System.out.println("total:" + result.getTotal());

        return result.getRecords();
    }

    // 自定义sql
    @PostMapping("/listPageC")
    public List<User> listPageC(@RequestBody QueryPageParam qParam) {

        // 设置分页
        Page<User> page = new Page<>();
        page.setCurrent(qParam.getPageNum());
        page.setSize(qParam.getPageSize());

        // 设置param
        HashMap param = qParam.getParam();
        String name = (String) param.get("username");

        // 查询
        // 查询使用自定义sql方法
        // IPage result = iUserService.pageC(page);
        // 查询方法使用MyBatis-Plus的方法
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getUsername, name);

        IPage result = iUserService.PageCC(page, lambdaQueryWrapper);

        return result.getRecords();
    }

    // 自定义sql
    @PostMapping("/listPageCC")
    public Result listPageCC(@RequestBody QueryPageParam qParam) {

        System.out.println(qParam);
        // 设置分页
        Page<User> page = new Page<>();
        page.setCurrent(qParam.getPageNum());
        page.setSize(qParam.getPageSize());

        // 设置param
        HashMap param = qParam.getParam();
        String name = (String) param.get("username");

        // 查询方法使用MyBatis-Plus的方法
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getUsername, name);

        IPage result = iUserService.PageCC(page, lambdaQueryWrapper);



        return Result.suc(result.getRecords(), result.getTotal());
    }
}
