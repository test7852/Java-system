package com.ht.bean.education;

import lombok.Data;

/**
 * @author lrq
 * @date 2020/6/11 15:44
 * 
 */
/**
    * 值班管理
    */
@Data
public class Teacherbe {
    /**
    * 值班id
    */
    private Integer beid;

    /**
    * 星期
    */
    private String week;

    /**
    * 排班名称
    */
    private String schedulingname;

    /**
    * 员工姓名
    */
    private String emp_name;

    /**
    * 值班要求
    */
    private String beask;

    /**
    * 总值班
    */
    private Integer besum;

    /**
    * 说明
    */
    private String explain;
}