package com.example.dmsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author higashi
 * @since 2024-11-14
 */
@ApiModel(value = "Warranty对象", description = "")
@Data
public class Warranty implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("保修单号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("维修物品名")
    private String name;

    @ApiModelProperty("故障图片")
    private byte[] image;

    @ApiModelProperty("开始时间")
    private LocalDateTime starttime;

    @ApiModelProperty("结束时间")
    private LocalDateTime endtime;

    @ApiModelProperty("学生学号")
    private String studentnumber;

    @ApiModelProperty("学生姓名")
    private String studentname;

    @ApiModelProperty("工作人员工号")
    private String worknumber;

    @ApiModelProperty("保修标题")
    private String title;

    @ApiModelProperty("工作人员名字")
    private String workname;

    @ApiModelProperty("备注")
    private String remark;

   
}
