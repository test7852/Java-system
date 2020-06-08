package com.ht.bean.education;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/8 20:40
 *  
 */
/**
    * 课程类别表
    */
@Data
public class Coursetype {
    /**
    * 课程类别id
    */
    private Integer coursetypeid;

    /**
    * 课程类别名称（公开课，专业课）
    */
    private String coursetypename;

    /**
    * 说明
    */
    private String remark;
}