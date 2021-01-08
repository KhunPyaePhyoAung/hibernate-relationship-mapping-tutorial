package me.khun.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Post {
    private Long id;
    private String content;
    private List<Tag> tags;
}
