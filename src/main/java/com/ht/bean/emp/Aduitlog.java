package com.ht.bean.emp;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/16 9:07
 * 
 */
/**
    * 根据巡查结果，录入巡查数据
    */
@Data
public class Aduitlog {
    private Integer aduitlogid;

    /**
    * 外键，考核指标id
    */
    private Integer aduitmodelid;

    /**
    * 员工id
    */
    private Integer empid;

    /**
    * 考核分数,根据考核指标规定的分数进行扣分负数或者加分为正数
    */
    private String scores;

    /**
    * 考核时间
    */
    private String auditdate;

    /**
    * 说明
    */
    private String remark;

    /**
    * 录入人员，从session取值
    */
    private String auditperson;

    /**
    * 图片
    */
    private String image;
}