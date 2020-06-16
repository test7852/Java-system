package com.ht.bean.student;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/16 9:06
 * 
 */
@Data
public class Replyscore {
    /**
    * 答辩id
    */
    private Integer replyid;

    /**
    * 学生id
    */
    private Integer empid;

    /**
    * 班级编号
    */
    private String clazz;
}