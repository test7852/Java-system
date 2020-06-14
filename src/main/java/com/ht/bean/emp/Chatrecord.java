package com.ht.bean.emp;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/14 10:02
 * 
 */
/**
    * 谈心记录，记录任课老师每个月跟学生谈心的情况
    */
@Data
public class Chatrecord {
    /**
    * 谈心主键id
    */
    private Integer chatid;

    /**
    * 学生表外键
    */
    private Integer sayface;

    /**
    * 员工表外键
    */
    private Integer teacher;

    /**
    * 地址
    */
    private String addr;

    /**
    * 谈心内容
    */
    private String sayscon;

    /**
    * 时间
    */
    private String chatdate;
}