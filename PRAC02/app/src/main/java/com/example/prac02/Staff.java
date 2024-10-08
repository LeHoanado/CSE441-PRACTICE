package com.example.prac02;

public class Staff {
    private String staffId;
    private String fullname;
    private  String birthdate;
    private double salary;

    public Staff(String staffId, String fullname, String birthdate, double salary) {
        this.staffId = staffId;
        this.fullname = fullname;
        this.birthdate = birthdate;
        this.salary = salary;
    }

    //getter và setter cho các thuộc tính
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
