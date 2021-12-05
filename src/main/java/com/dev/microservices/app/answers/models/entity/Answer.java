package com.dev.microservices.app.answers.models.entity;

import com.dev.microservices.commons.exams.models.entity.Question;
import com.dev.microservices.commons.students.models.entity.Student;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    @OneToOne(fetch = FetchType.LAZY)
    private Question question;


}
