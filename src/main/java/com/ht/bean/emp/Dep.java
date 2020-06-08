package com.ht.bean.emp;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/8 20:41
 *  
 */
/**
    * 部门设置
    */
@Data
public class Dep {
    private Integer depid;

    /**
    * 部门名称
    */
    private String depname;

    /**
    * 父部门名称
    */
    private Integer parentid;

    /**
    * 部门负责人
    */
    private String chairman;

    /**
    * 备注
    */
    private String remark;

    /**
    * 是否为人事部
    */
    private Integer personnel;
}