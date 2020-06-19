package com.ht.bean.aduit;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/19 19:07
 * 
 */
/**
    * 请假申请表
    */
@Data
public class Holiday {
    private Integer holidayid;

    /**
    * 关联Emp主键(请假人)
    */
    private Integer empid;

    /**
    * 假期天数
    */
    private Double holidayday;

    /**
    * 开始时间
    */
    private String starttime;

    /**
    * 结束时间
    */
    private String endtime;

    /**
    * 标题
    */
    private String title;

    /**
    * 状态 1:审批中 2：已完成 3：不批准
    */
    private Integer status;

    /**
    * 内容
    */
    private String remark;
}