package com.join.joinblog.entity.form;

/**
 * @Author: Nies
 * @Description:
 * @Date: 19:13 2019/10/12
 */
public class Form {
    private int id,age,rank1,rank2;
    private String name,grade,department,college,major,phone,QQ,mail,introduce;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getRank1() {
        return rank1;
    }

    public void setRank1(int rank1) {
        this.rank1 = rank1;
    }

    public int getRank2() {
        return rank2;
    }

    public void setRank2(int rank2) {
        this.rank2 = rank2;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "Form{" +
                "id=" + id +
                ", age=" + age +
                ", grade=" + grade +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", rank1='" + rank1 + '\'' +
                ", rank2='" + rank2 + '\'' +
                ", phone='" + phone + '\'' +
                ", QQ='" + QQ + '\'' +
                ", mail='" + mail + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}
