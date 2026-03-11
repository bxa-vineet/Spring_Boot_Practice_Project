package com.telusko.quizapp.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.telusko.quizapp.models.QuestionWrapper;
import com.telusko.quizapp.models.Questions;
import com.telusko.quizapp.models.Quiz;
import com.telusko.quizapp.repository.QuestionReposistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.telusko.quizapp.repository.QuizRepository;

@Service
public class QuizService {
    @Autowired
    QuestionReposistory questRepo;
    @Autowired
    QuizRepository quizRepo;
    public ResponseEntity<String> createQuiz(String category,int num, String title){
        List<Questions> questions = questRepo.findRandomQuestionsByCategory(category,num);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestion(questions);
        quizRepo.save(quiz);
        return  new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id){
        Optional<Quiz>  quiz = quizRepo.findById(id);

        if(quiz.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Questions> questionsFromDB = quiz.get().getQuestion();
        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for(Questions q : questionsFromDB){
           QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getOption_1(),q.getOption_2(),q.getOption_3(),q.getOption_4(),q.getQuestionTitle());
           questionForUser.add(qw);
        }
        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }
}
