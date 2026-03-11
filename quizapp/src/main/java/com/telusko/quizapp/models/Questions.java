package com.telusko.quizapp.models;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "questions_table")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String category;
    private String difficultylevel;
    private String option_1;
    private String option_2;
    private String option_3;
    private String option_4;
    private String questionTitle;
    private String rightAnswer;

}
