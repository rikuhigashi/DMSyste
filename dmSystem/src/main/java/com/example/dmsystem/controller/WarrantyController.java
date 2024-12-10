package com.example.dmsystem.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dmsystem.common.QueryPageParam;
import com.example.dmsystem.common.Result;
import com.example.dmsystem.entity.Warranty;
import com.example.dmsystem.service.IWarrantyService;

import ch.qos.logback.core.util.StringUtil;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author higashi
 * @since 2024-11-13
 */
@RestController
@RequestMapping("/warranty")
public class WarrantyController {

    @Autowired
    private IWarrantyService iWarrantyService;

    @PostMapping("/listSearch")
    public Result listSearch(@RequestBody Warranty warranty) {

        // 不使用param中的数据
        LambdaQueryWrapper<Warranty> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        if (StringUtil.notNullNorEmpty(warranty.getTitle())) {
            lambdaQueryWrapper.like(Warranty::getTitle, warranty.getTitle());
        }

        return Result.suc(iWarrantyService.list(lambdaQueryWrapper));
    }

    @PostMapping("/listSearchAndPagination")
    public Result Pagination(@RequestBody QueryPageParam qParam) {
        // System.out.println(qParam);

        HashMap<String, Object> hMap = qParam.getParam();
        String title = (String) hMap.get("title");

        Integer studentnumber = (Integer) hMap.get("studentnumber");
        Integer worknumber = (Integer) hMap.get("worknumber");

        // 使用param中的数据
        LambdaQueryWrapper<Warranty> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(title)) {
            lambdaQueryWrapper.like(Warranty::getTitle, title);
        };

        if (studentnumber != null) {
            lambdaQueryWrapper.like(Warranty::getStudentnumber, studentnumber);
        }
        if (worknumber != null) {
            lambdaQueryWrapper.like(Warranty::getWorknumber, worknumber);
        }

        // 设置分页
        Page<Warranty> page = new Page<>();
        page.setCurrent(qParam.getPageNum());
        page.setSize(qParam.getPageSize());


        IPage result = iWarrantyService.page(page, lambdaQueryWrapper);

        return Result.suc(result.getRecords(), result.getTotal());
    }

    
    @PostMapping("/saveOrUpdate")
    public Result save(@RequestBody Warranty warranty) {

        return iWarrantyService.saveOrUpdate(warranty)? Result.suc():Result.fail();
    }
    

    @DeleteMapping("/del")
    public Result del(@RequestParam("id") String id){
        return iWarrantyService.removeById(id)?Result.suc():Result.fail();
    }

}
