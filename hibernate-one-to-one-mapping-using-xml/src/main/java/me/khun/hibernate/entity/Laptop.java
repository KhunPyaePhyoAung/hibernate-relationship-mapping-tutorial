package me.khun.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Laptop {
    private Long id;
    private String brand;
    private String description;
    private Person person;
}
