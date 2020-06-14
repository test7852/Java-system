package com.ht.bean.emp;

import lombok.Data;

/**
 * @author lrq
 * @date 2020/6/7 20:19
 */
/**
 * 员工表
 */
@Data
public class Empinfo {
    /**
    * 员工编号
    */
    private Integer emp_id;

    /**
    * 员工姓名
    */
    private String emp_name;

    private Integer dep_id;

    private String emp_sex;

    private String birthday;

    private String cardno;

    /**
    * 籍贯
    */
    private String nation;

    private String phone;

    private String qqcode;

    private String weixin;

    /**
    * 婚姻状况（已婚，单身，离异，丧偶）
    */
    private String email;

    private String married;

    /**
    * 毕业学校
    */
    private String university;

    /**
    * 专业
    */
    private String major;

    /**
    * 学历
    */
    private String education;

    private String address;

    /**
    * 支付宝账号
    */
    private String alipay;

    /**
    * 入职日期
    */
    private String hireday;

    /**
    * 离职日期
    */
    private String fireday;

    private String password;

    private Integer status;

    private Integer post_Id;

    //新加字段
    //职位
    private String postname;
    //部门
    private String depname;
}