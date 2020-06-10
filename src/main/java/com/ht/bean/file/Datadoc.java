package com.ht.bean.file;

/**
 * @author 王钟华
 * @date 2020-06-09 10:20
 */

public class Datadoc {
    int docId;
    String dataName;
    String url;
    String optime;
    String remark;
    int empId;

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOptime() {
        return optime;
    }

    public void setOptime(String optime) {
        this.optime = optime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "Datadoc{" +
                "docId=" + docId +
                ", dataName='" + dataName + '\'' +
                ", url='" + url + '\'' +
                ", optime='" + optime + '\'' +
                ", remark='" + remark + '\'' +
                ", empId=" + empId +
                '}';
    }

    public Datadoc() {
    }

    public Datadoc(int docId, String dataName, String url, String optime, String remark, int empId) {
        this.docId = docId;
        this.dataName = dataName;
        this.url = url;
        this.optime = optime;
        this.remark = remark;
        this.empId = empId;
    }
}
