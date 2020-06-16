package com.ht.bean.aduit;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/16 9:08
 * 
 */
/**
    * 考核指标表
    */
@Data
public class Aduitmodel {
    private Integer aduitmodelid;

    /**
    * 考核内容
    */
    private String aduitname;

    /**
    * 考核分数
    */
    private Integer scores;

    /**
    * 关联部门表
    */
    private Integer depid;

    /**
    * 说明
    */
    private String remark;

    /**
     * 用来存放部门姓名
     */
    private String depname;
}