package com.ht.bean.education;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/22 8:37
 * 
 */
/**
    * 班级成绩表
    */
@Data
public class Classreply {
    private Integer replyid;

    /**
    * 关联班级id
    */
    private Integer classid;

    /**
    * 关联答辩项目
    */
    private Integer projectid;

    /**
    * 员工表外键 session里面取
    */
    private Integer empid;
}