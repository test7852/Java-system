package com.ht.bean.student;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/10 10:27
 * 
 */
/**
    * 成绩记录管理    
    */
@Data
public class StudentScore {
    /**
    * 成绩主键id
    */
    private Integer scoreid;

    /**
    * 学生表外键
    */
    private Integer stuid;

    /**
    * 学生成绩
    */
    private Integer score;

    /**
    * 补考成绩
    */
    private Integer rescore;

    /**
    * 关联课程id
    */
    private Integer courseid;

    /**
    * 1:笔试2:机试3:模拟面试
    */
    private String testtype;

    /**
    * 关联学期id
    */
    private Integer termid;

    /**
    * 考试时间
    */
    private String scoretime;

    /**
    * 录入人员,获取session值
    */
    private Integer empid;

    /**
    * 备注
    */
    private String remark;
}