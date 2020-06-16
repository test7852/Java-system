package com.ht.bean.student;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/16 9:06
 * 
 */
/**
    * 学生id
答辩id
成绩id

    */
@Data
public class Classscore {
    /**
    * 学生id
    */
    private Integer empid;

    /**
    * 成绩id
    */
    private Integer scoreid;

    /**
    * 班级编号
    */
    private String clazz;
}