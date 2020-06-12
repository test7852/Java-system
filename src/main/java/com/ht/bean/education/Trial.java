package com.ht.bean.education;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/12 10:36
 * 
 */
/**
    * 试讲与培训计划表
针对员工发起一个试讲与培训计划

    */
@Data
public class Trial {
    /**
    * 试讲与培训计划id

    */
    private Integer trialid;

    /**
    * 日期

    */
    private String date;

    /**
    * 时间(星期一---星期日)
    */
    private String time;

    /**
    * 关联课程id
    */
    private Integer courseid;

    /**
    * 授课类型(试讲/培训)
    */
    private String type;

    /**
    * 员工id关联员工表(授课老师)
    */
    private Integer empid;

    /**
    * 备注(针对课程重要内容)
    */
    private String remark;
}