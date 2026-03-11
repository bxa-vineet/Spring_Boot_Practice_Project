package com.telusko.quizapp.controller;
import com.telusko.quizapp.models.Questions;
import java.util.List;
import com.telusko.quizapp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService qs ;

    @PostMapping("/insertallquestion")
    public List<Questions> insertdata(@RequestBody List<Questions> ques){
        return qs.addAllQuestions(ques);

    }

    @GetMapping("/allquestions")
    public List<Questions> getAllQuestions() {
       return qs.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public List<Questions> getAllQuestionsBycategory(@PathVariable String category) {
        return qs.getAllQuestionsByCategory(category);
    }

    @PostMapping("/add")
    public Questions add(@RequestBody Questions ques){
        return qs.addQuestion(ques);
    }












//
//    @GetMapping("/category/{category}/{difficultylevel}")
//    public List<Questions> getAllQuestionsBycategoryAndDiff(@PathVariable String category,@PathVariable String difficultylevel) {
//        return qs.getAllQuestionsByCategoryAndDifficultyLevel(category,difficultylevel);
//    }
}
