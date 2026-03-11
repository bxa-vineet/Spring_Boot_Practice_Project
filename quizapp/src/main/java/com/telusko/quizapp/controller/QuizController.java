package com.telusko.quizapp.controller;
import com.telusko.quizapp.models.QuestionWrapper;
import com.telusko.quizapp.models.Questions;
import com.telusko.quizapp.services.QuizService;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int num, @RequestParam String title){
        return quizService.createQuiz(category,num,title);
//        return new ResponseEntity<>("I am here", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestion(id);
    }


}
