package com.ht.bean.education;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/19 19:09
 * 
 */
@Data
public class Classscore {
    /**
    * id
    */
    private Integer cscoreid;

    /**
    * 课程id
    */
    private Integer courseid;

    /**
    * 班级id
    */
    private Integer classid;

    /**
    * 考试类别
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
    * 录入人员
    */
    private Integer empid;

    /**
    * 备注
    */
    private String remark;
}