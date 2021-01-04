package me.khun.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Tag {
    private Long id;
    private String name;
    private List<Post> posts;
}
