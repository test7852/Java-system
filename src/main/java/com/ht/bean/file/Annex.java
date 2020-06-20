package com.ht.bean.file;

import lombok.Data;

/**
 * @author lrq
 * @date 2020/6/19 8:36
 * 
 */
/**
    * 附件表
    */
@Data
public class Annex {
    private Integer annexid;

    /**
    * 类型选择(1:员工,2:学生)
    */
    private String sename;

    /**
    * 关联员工或者学生ID
    */
    private Integer seid;

    /**
    * 附件名称
    */
    private String annexname;

    /**
    * 上传附件
    */
    private String annexnames;

    /**
    * 上传时间
    */
    private String annexdate;

    /**
    * 说明
    */
    private String remark;

    /**
    * 上传人
    */
    private String sessionname;
}