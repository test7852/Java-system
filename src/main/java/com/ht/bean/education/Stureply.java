package com.ht.bean.education;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/22 8:38
 * 
 */
/**
    * 学生答辩成绩表
    */
@Data
public class Stureply {
    private Integer srid;

    /**
    * 关联班级答辩id
    */
    private Integer replyid;

    /**
    * 关联学生id
    */
    private Integer stuid;

    /**
    * 功能完善50
    */
    private Double score1;

    /**
    * 技术难度10
    */
    private Double score2;

    /**
    * 界面完美10
    */
    private Double score3;

    /**
    * 回答问题10
    */
    private Double score4;

    /**
    * 演示方法10
    */
    private Double score5;

    /**
    * 语言表达10
    */
    private Double score6;

    /**
    * 总分100
    */
    private Double score7;

    /**
    * 说明
    */
    private String remark;
}