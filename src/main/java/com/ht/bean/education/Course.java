package com.ht.bean.education;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/8 20:35
 *  
 */
/**
    * 课程管理表
    */
@Data
public class Course {
    /**
    * 课程id
    */
    private Integer courseid;

    /**
    * 课程名称
    */
    private String coursename;

    /**
    * 是否必修
    */
    private String isobligatory;

    /**
    * 课程类别id
    */
    private Integer coursetypeid;

    /**
    * 说明
    */
    private String remark;
}