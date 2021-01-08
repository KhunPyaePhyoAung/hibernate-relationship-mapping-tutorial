package me.khun.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "question_body", nullable = false)
    private String questionBody;

    @OneToMany(cascade = CascadeType.ALL)
    @OrderColumn(name = "type")
    @JoinColumn(name = "question_id")
    private List<Answer> answers;
}
