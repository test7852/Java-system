package com.ht.bean.emp;

/**
 * @author lrq
 * @date 2020/6/7 20:19
 */
public class Empinfo {
    /**
    * 员工编号
    */
    private Integer empId;

    /**
    * 员工姓名
    */
    private String empName;

    private Integer depId;

    private String empSex;

    private String birthday;

    private String cardno;

    /**
    * 籍贯
    */
    private String nation;

    private String phone;

    private String qqcode;

    private String weixin;

    /**
    * 婚姻状况（已婚，单身，离异，丧偶）
    */
    private String email;

    private String married;

    /**
    * 毕业学校
    */
    private String university;

    /**
    * 专业
    */
    private String major;

    /**
    * 学历
    */
    private String education;

    private String address;

    /**
    * 支付宝账号
    */
    private String alipay;

    /**
    * 入职日期
    */
    private String hireday;

    /**
    * 离职日期
    */
    private String fireday;

    private String password;

    private Integer status;

    private Integer postId;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQqcode() {
        return qqcode;
    }

    public void setQqcode(String qqcode) {
        this.qqcode = qqcode;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMarried() {
        return married;
    }

    public void setMarried(String married) {
        this.married = married;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

    public String getHireday() {
        return hireday;
    }

    public void setHireday(String hireday) {
        this.hireday = hireday;
    }

    public String getFireday() {
        return fireday;
    }

    public void setFireday(String fireday) {
        this.fireday = fireday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "Empinfo{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", depId=" + depId +
                ", empSex='" + empSex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", cardno='" + cardno + '\'' +
                ", nation='" + nation + '\'' +
                ", phone='" + phone + '\'' +
                ", qqcode='" + qqcode + '\'' +
                ", weixin='" + weixin + '\'' +
                ", email='" + email + '\'' +
                ", married='" + married + '\'' +
                ", university='" + university + '\'' +
                ", major='" + major + '\'' +
                ", education='" + education + '\'' +
                ", address='" + address + '\'' +
                ", alipay='" + alipay + '\'' +
                ", hireday='" + hireday + '\'' +
                ", fireday='" + fireday + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", postId=" + postId +
                '}';
    }
}