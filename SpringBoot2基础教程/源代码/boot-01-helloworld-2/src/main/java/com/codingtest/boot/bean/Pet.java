package com.codingtest.boot.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Pet {
    private String name;
    private Double weight;
}