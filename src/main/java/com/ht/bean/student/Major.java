package com.ht.bean.student;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/15 20:29
 * 
 */
/**
    * 专业表
    */
@Data
public class Major {
    /**
    * 专业id
    */
    private Integer majorid;

    /**
    * 专业名称
    */
    private String majorname;

    /**
    * 系id
    */
    private Integer deptid;

    /**
    * 说明
    */
    private String remark;
}