package com.codingTest.boot.bean;

import lombok.Data;
import lombok.ToString;

/**
 * 用户
 */
@Data
@ToString
public class User {
    private String name;
    private Integer age;

    private Pet pet;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
