package com.ht.bean.student;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/15 16:02
 * 
 */
/**
    * 届别管理
    */
@Data
public class Studentfall {
    /**
    * 届别id
    */
    private Integer fallid;

    /**
    * 届别名称
    */
    private String level;

    /**
    * 说明
    */
    private String remark;
}