package com.ht.bean.student;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/10 10:47
 * 
 */
/**
    * 分班管理
    */
@Data
public class Studentclass {
    /**
    * 分班id
    */
    private Integer classid;

    /**
    * 班级类别
    */
    private Integer classno;

    /**
    * 班级名称
    */
    private String classname;

    /**
    * 班级人数
    */
    private Integer count;

    /**
    * 授课老师员工表外键
    */
    private String teacher;

    /**
    * 班主任员工表外键
    */
    private String classteacher;

    /**
    * 备注
    */
    private String remark;

    /**
    * 关联班级类别
    */
    private Integer falled;

    /**
    * 关联系
    */
    private Integer deptid;

    /**
    * 关联专业表
    */
    private Integer majorid;
}