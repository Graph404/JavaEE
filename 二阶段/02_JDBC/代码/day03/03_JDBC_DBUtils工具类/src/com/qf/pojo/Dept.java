package com.qf.pojo;

import java.util.List;

/**
 * 作者：威哥
 * 描述：永无Bug
 */
public class Dept {
    private Integer dno;
    private String name;
    private String address;

    @Override
    public String toString() {
        return "Dept{" +
                "dno=" + dno +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    public Integer getDno() {
        return dno;
    }

    public void setDno(Integer dno) {
        this.dno = dno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Dept() {
    }

    public Dept(Integer dno, String name, String address) {
        this.dno = dno;
        this.name = name;
        this.address = address;
    }
}
