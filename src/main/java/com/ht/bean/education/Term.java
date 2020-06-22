package com.ht.bean.education;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/19 19:11
 * 
 */
@Data
public class Term {
    /**
    * id
    */
    private Integer termid;

    /**
    * 学期名称
    */
    private String termname;

    /**
    * 备注
    */
    private String remark;
}