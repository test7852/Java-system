package com.ht.bean.student;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/15 16:00
 * 
 */
/**
    * 系管理
    */
@Data
public class Dept {
    /**
    * id
    */
    private Integer deptid;

    /**
    * 系名称
    */
    private String deptname;

    /**
    * 说明
    */
    private String remark;
}