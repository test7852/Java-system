package com.ht.bean.aduit;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/16 20:42
 * 
 */
/**
    * 学生申请设备维修表: 
    */
@Data
public class EquipmentrepairCopy1 {
    private Integer equipmentid;

    /**
    * 维修设备名称
    */
    private String equipmenttype;

    /**
    * 维修状态1未完成,2已完成
    */
    private Integer status;

    /**
    * 关联班级表主键
    */
    private Integer classes;

    /**
    * 关联学生表申请人
    */
    private Integer student;

    /**
    * 备注
    */
    private String remark;

    /**
    * 系名称
    */
    private Integer depid;

    /**
    * 1学生 2员工
    */
    private Integer usertype;

    /**
    * 开始时间
    */
    private String starttime;

    /**
    * 结束时间
    */
    private String endtime;
}