package com.ht.bean.emp;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/12 20:30
 * 
 */
/**
    * 工作日志
    */
@Data
public class Workdiary {
    private Integer worklogid;

    /**
    * 关联Emp表empid字段
    */
    private Integer empid;

    /**
    * 填写日期
    */
    private String workday;

    /**
    * 本周情况描述
    */
    private String weekcur;

    /**
    * 问题学生情况反馈
    */
    private String studentquestion;

    /**
    * 意见建议
    */
    private String idea;

    /**
    * 下周工作计划
    */
    private String weeknext;
}