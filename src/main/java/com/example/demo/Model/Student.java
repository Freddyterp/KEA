package com.example.demo.Model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Student{
    public int id;
    public String first_name;
    public String last_name;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // needed for input field on html pages (in order to serve the right format)
    public int cpr;
    public Date enrollment_date;

    public Student(int id, String first_name, String last_name, int cpr, Date enrollment_date) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.cpr = cpr;
        this.enrollment_date = enrollment_date;
    }

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getEnrollment_date() {
        return enrollment_date;
    }

    public void setEnrollment_date(Date enrollment_date) {
        this.enrollment_date = enrollment_date;
    }

    public int getCpr() {
        return cpr;
    }

    public void setCpr(int cpr) {
        this.cpr = cpr;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + first_name + '\'' +
                ", lastName='" + last_name + '\'' +
                ", enrollmentDate=" + enrollment_date +
                ", cpr='" + cpr + '\'' +
                '}';
    }
}
