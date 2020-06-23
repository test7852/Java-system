package com.ht.bean.aduit;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/19 8:10
 * 
 */
/**
    * 完整维修管理(2合1)
    */
@Data
public class Maintain {
    /**
    * id
    */
    private Integer wxid;

    /**
    * 维修设备名称
    */
    private String equipmenttype;

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
    * 班级id
    */
    private Integer classno;

    /**
    * 部门 id
    */
    private Integer depid;

    /**
     * 备注
     */
    private String remark;

    /**
     * 部门id
     */
    private Integer emp_id;
}