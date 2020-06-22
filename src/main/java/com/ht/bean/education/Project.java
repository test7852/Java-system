package com.ht.bean.education;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/22 8:38
 * 
 */
/**
    * 项目答辩名称表
    */
@Data
public class Project {
    /**
    * 主键，标识列，自动生成
    */
    private Integer projectid;

    /**
    * 项目名称
    */
    private String projectname;

    /**
    * 说明
    */
    private String remark;
}