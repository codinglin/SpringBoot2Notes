package com.codingTest.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 宠物
 */
@AllArgsConstructor // 全参构造器
@NoArgsConstructor // 无参构造器
@Data
@ToString
public class Pet {
    private String name;
}
