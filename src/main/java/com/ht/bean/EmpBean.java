package com.ht.bean;

public class EmpBean {
    private int emp_Id; //员工编号
    private String emp_Name; //员工姓名
    private int dep_Id; //关联dep表depid字段
    private String emp_Sex; //性别（男，女）
    private String Birthday;//出生日期
    private String Cardno;//身份证号码（唯一）
    private String nation;//籍贯
    private String Phone;//手机号码
    private String QQcode;//QQ号码
    private String Weixin;//微信号码
    private String Email;//邮箱地址
    private String married;//婚姻状况（已婚，单身，离异，丧偶）
    private String University;//毕业学校
    private String Major;//专业
    private String Education;//学历
    private String Address;//家庭地址
    private String alipay;//支付宝账号(唯一）
    private String hireDay;//入职日期
    private String fireDay;//离职日期
    private String password;//登录密码
    private int status;//状态
    private int post_Id;//职务id

    @Override
    public String toString() {
        return "EmpBean{" +
                "emp_Id=" + emp_Id +
                ", emp_Name='" + emp_Name + '\'' +
                ", dep_Id=" + dep_Id +
                ", emp_Sex='" + emp_Sex + '\'' +
                ", Birthday='" + Birthday + '\'' +
                ", Cardno='" + Cardno + '\'' +
                ", nation='" + nation + '\'' +
                ", Phone='" + Phone + '\'' +
                ", QQcode='" + QQcode + '\'' +
                ", Weixin='" + Weixin + '\'' +
                ", Email='" + Email + '\'' +
                ", married='" + married + '\'' +
                ", University='" + University + '\'' +
                ", Major='" + Major + '\'' +
                ", Education='" + Education + '\'' +
                ", Address='" + Address + '\'' +
                ", alipay='" + alipay + '\'' +
                ", hireDay='" + hireDay + '\'' +
                ", fireDay='" + fireDay + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", post_Id=" + post_Id +
                '}';
    }

    public int getEmp_Id() {
        return emp_Id;
    }

    public void setEmp_Id(int emp_Id) {
        this.emp_Id = emp_Id;
    }

    public String getEmp_Name() {
        return emp_Name;
    }

    public void setEmp_Name(String emp_Name) {
        this.emp_Name = emp_Name;
    }

    public int getDep_Id() {
        return dep_Id;
    }

    public void setDep_Id(int dep_Id) {
        this.dep_Id = dep_Id;
    }

    public String getEmp_Sex() {
        return emp_Sex;
    }

    public void setEmp_Sex(String emp_Sex) {
        this.emp_Sex = emp_Sex;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getCardno() {
        return Cardno;
    }

    public void setCardno(String cardno) {
        Cardno = cardno;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getQQcode() {
        return QQcode;
    }

    public void setQQcode(String QQcode) {
        this.QQcode = QQcode;
    }

    public String getWeixin() {
        return Weixin;
    }

    public void setWeixin(String weixin) {
        Weixin = weixin;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMarried() {
        return married;
    }

    public void setMarried(String married) {
        this.married = married;
    }

    public String getUniversity() {
        return University;
    }

    public void setUniversity(String university) {
        University = university;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

    public String getHireDay() {
        return hireDay;
    }

    public void setHireDay(String hireDay) {
        this.hireDay = hireDay;
    }

    public String getFireDay() {
        return fireDay;
    }

    public void setFireDay(String fireDay) {
        this.fireDay = fireDay;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPost_Id() {
        return post_Id;
    }

    public void setPost_Id(int post_Id) {
        this.post_Id = post_Id;
    }
}
