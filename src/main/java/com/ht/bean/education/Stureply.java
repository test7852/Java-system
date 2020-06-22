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
    private Double score1=(double)0;

    /**
    * 技术难度10
    */
    private Double score2=(double)0;

    /**
    * 界面完美10
    */
    private Double score3=(double)0;

    /**
    * 回答问题10
    */
    private Double score4=(double)0;

    /**
    * 演示方法10
    */
    private Double score5=(double)0;

    /**
    * 语言表达10
    */
    private Double score6=(double)0;

    /**
    * 总分100
    */
    private Double score7=(double)0;

    /**
    * 说明
    */
    private String remark;
}