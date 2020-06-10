package com.ht.bean.student;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/10 10:27
 * 
 */
/**
    * 学生答辩管理   
    */
@Data
public class Studentreplyscore {
    /**
    * 成绩主键id
    */
    private Integer replyid;

    /**
    * 学生表外键
    */
    private Integer studentid;

    /**
    * 关联答辩项目
    */
    private Integer projectid;

    /**
    * 打分老师管理员工表外键
    */
    private Integer empid;

    /**
    * 功能完善50
    */
    private String score1;

    /**
    * 技术难度10
    */
    private String score2;

    /**
    * 界面完美10
    */
    private String score3;

    /**
    * 回答问题10
    */
    private String score4;

    /**
    * 演示方法10
    */
    private String score5;

    /**
    * 语言表达10
    */
    private String score6;

    /**
    * 总分100
    */
    private String score7;

    /**
    * 备注
    */
    private String remark;
}