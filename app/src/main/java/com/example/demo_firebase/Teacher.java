package com.example.demo_firebase;

public class Teacher {
    String name , course, email, surl;

    public Teacher(String name, String course, String email, String surl) {
        this.name = name;
        this.course = course;
        this.email = email;
        this.surl = surl;
    }

    public Teacher() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }
}
