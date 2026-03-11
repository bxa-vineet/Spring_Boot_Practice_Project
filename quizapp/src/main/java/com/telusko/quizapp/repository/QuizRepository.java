package com.telusko.quizapp.repository;
import com.telusko.quizapp.models.Questions;
import com.telusko.quizapp.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Integer> {


}
