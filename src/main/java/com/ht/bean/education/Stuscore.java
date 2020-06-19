package com.ht.bean.education;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/19 19:11
 * 
 */
@Data
public class Stuscore {
    /**
    * id
    */
    private Integer ssid;

    /**
    * 班级成绩id
    */
    private Integer scoreid;

    /**
    * 学生id
    */
    private Integer stuid;

    /**
    * 学生成绩
    */
    private String scure;

    /**
    * 补考成绩
    */
    private String rescore;

    /**
    * 备注
    */
    private String remark;
}