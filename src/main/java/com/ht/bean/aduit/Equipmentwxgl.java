package com.ht.bean.aduit;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/16 20:43
 * 
 */
/**
    * 维修管理
    */
@Data
public class Equipmentwxgl {
    private Integer wxid;

    /**
    * 维修设备名称
    */
    private String equipmenttype;

    /**
    * 部门/班级
    */
    private String usertype;

    /**
    * 类别
    */
    private String wxcategory;

    /**
    * 开始时间
    */
    private String starttime;

    /**
    * 结束时间
    */
    private String endtime;

    /**
    * 维修状态1未完成,2已完成
    */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 部门id
     */
    private Integer emp_id;
}