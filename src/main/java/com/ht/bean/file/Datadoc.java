package com.ht.bean.file;

import lombok.Data;

/**
 * @author 王金宝
 * @date 2020/6/11 8:43
 * 
 */
/**
    * 资料文档管理
    */
@Data
public class Datadoc {
    /**
    * 文件id
    */
    private Integer docid;

    /**
    * 资料名称
    */
    private String dataname;

    /**
    * 文件url地址
    */
    private String url;

    /**
    * 上传时间
    */
    private String optime;

    /**
    * 备注
    */
    private String remark;

    /**
    * 上传人员   关联员工表主键
    */
    private Integer empid;

    public Datadoc() {
    }

    public Datadoc(Integer docid, String dataname, String url, String optime, String remark, Integer empid) {
        this.docid = docid;
        this.dataname = dataname;
        this.url = url;
        this.optime = optime;
        this.remark = remark;
        this.empid = empid;
    }

}