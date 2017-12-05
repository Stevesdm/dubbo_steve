package com.steve.model;

import java.io.Serializable;

/**
 * Created by SteveJobson on 2017/7/13.
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    String name;
    Integer age;
    String address;

    public Person() {
    }

    public Person(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
