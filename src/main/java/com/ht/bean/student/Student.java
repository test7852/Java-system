package com.ht.bean.student;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/8 20:42
 *  
 */
/**
    * 学生资料管理    
 户口性质:	 1.农业  2.非农
专业类别:	 1.中技  2.高技  3.3+2
学习方式：1.全日制  2.函授
是否中专：1.否   2.是
中专学籍：1.已退 2.保留   
    */
@Data
public class Student {
    /**
    * 学生主键id
    */
    private Integer studid;

    /**
    * 登入密码
    */
    private String password;

    /**
    * 学生姓名
    */
    private String stuname;

    /**
    * 毕业学校
    */
    private String middleschool;

    /**
    * 性别
    */
    private String sex;

    /**
    * 年龄
    */
    private Integer age;

    /**
    * 出生年月
    */
    private String birthday;

    /**
    * 学生电话
    */
    private String phone;

    /**
    * 家庭地址
    */
    private String addr;

    /**
    * 班级外键id
    */
    private Integer clazz;

    /**
    * 宿舍外键id
    */
    private Integer huor;

    /**
    * 入学时间
    */
    private String entertime;

    /**
    * 介绍老师
    */
    private String introduretech;

    /**
    * 学生状态
    */
    private String stat;

    /**
    * 民族
    */
    private String nation;

    /**
    * 籍贯
    */
    private String natives;

    /**
    * 户口性质
    */
    private String residence;

    /**
    * 身份证号
    */
    private Integer cardid;

    /**
    * 就读专业
    */
    private String professional;

    /**
    * 专业类别
    */
    private String prolevel;

    /**
    * 学习类别
    */
    private String studytype;

    /**
    * 家长姓名
    */
    private String parents;

    /**
    * 家长电话
    */
    private String parentsphone;

    /**
    * 面试人
    */
    private String audition;

    /**
    * 面试人意见
    */
    private String auditionoption;

    /**
    * 是否中专
    */
    private String isvocational;

    /**
    * 中专学校
    */
    private String vocationalsch;

    /**
    * 中专学籍
    */
    private String vocationalflag;

    /**
    * 省录取号
    */
    private Integer enrollno;

    /**
    * 录取成绩
    */
    private String score;

    /**
    * 是否低保
    */
    private String dibao;

    /**
    * 生源类型
    */
    private String sourcetype;

    /**
    * 担保人
    */
    private String guarantee;

    /**
    * 是否当兵
    */
    private String soldier;

    /**
    * 报名号
    */
    private String registration;

    /**
    * 是否住校
    */
    private String zhuxiao;

    /**
    * 备注
    */
    private String remark;

    /**
    * 退学
    */
    private String tuixue;

    /**
    * 休学
    */
    private String xiuxue;

    /**
    * 学号
    */
    private Integer stuno;

    /**
    * 是否送电脑
    */
    private String computer;

    /**
    * 是否领用
    */
    private String collar;

    /**
    * 助学金
    */
    private String grants;
}