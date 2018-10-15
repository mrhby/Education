package com.entity;

import java.util.Date;

public class Student {

    private int stuid;
    private String stunam;
    private String stusex;
    private Date stubir;
    private String stugra;
    private String password;

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public String getStunam() {
        return stunam;
    }

    public void setStunam(String stunam) {
        this.stunam = stunam;
    }

    public String getStusex() {
        return stusex;
    }

    public void setStusex(String stusex) {
        this.stusex = stusex;
    }

    public Date getStubir() {
        return stubir;
    }

    public void setStubir(Date stubir) {
        this.stubir = stubir;
    }

    public String getStugra() {
        return stugra;
    }

    public void setStugra(String stugra) {
        this.stugra = stugra;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
