package me.khun.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Answer {
    private Long id;
    private String answerBody;
    private String postedBy;
}
