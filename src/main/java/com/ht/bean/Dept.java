package com.ht.bean;


/**
 * @author lrq
 * @date 2020/6/7 19:22
 */
/**
    * 系管理
    */
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

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptid=" + deptid +
                ", deptname='" + deptname + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}