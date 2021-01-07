package me.khun.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private Long id;
    private String name;
    private Integer age;
    private Laptop laptop;
}
