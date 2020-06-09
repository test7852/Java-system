package com.ht.bean.education;

import lombok.Data;

/**
 * @author lrq
 * @date 2020/6/7 19:22
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