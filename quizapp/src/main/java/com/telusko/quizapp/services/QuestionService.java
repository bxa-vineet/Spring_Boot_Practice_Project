package com.telusko.quizapp.services;
import java.util.*;
import com.telusko.quizapp.repository.QuestionReposistory;
import com.telusko.quizapp.models.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  //We tell Spring so that Spring can create, manage, and inject the object automatically.
public class QuestionService {
    @Autowired // Spring automatically creates and gives the required object to the class.
     QuestionReposistory questionrepo;

    public List<Questions> addAllQuestions(List<Questions> list){
        return questionrepo.saveAll(list);
    }

     public List<Questions>  getAllQuestions(){
        return questionrepo.findAll();
     }

    public List<Questions>  getAllQuestionsByCategory(String cate){
        return questionrepo.findByCategory(cate);
    }

    public Questions addQuestion(Questions ques){
        return questionrepo.save(ques);
    }
//
//    public List<Questions> getAllQuestionsByCategoryAndDifficultyLevel(String cate,String diff){
//        return questionrepo.findByCategoryAndDifficultylevel(cate,diff);
//    }
}