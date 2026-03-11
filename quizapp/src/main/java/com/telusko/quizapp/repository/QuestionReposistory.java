package com.telusko.quizapp.repository;
import com.telusko.quizapp.models.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


public interface QuestionReposistory extends JpaRepository<Questions,Long> {
    public List<Questions> findByCategory(String cate);
//    public List<Questions> findByCategoryAndDifficultylevel(String cate,String diff);

    @Query(value = "Select * from questions_table q Where q.category=:category Order By RANDOM() LIMIT :num"
                   , nativeQuery = true)
    List<Questions> findRandomQuestionsByCategory(String category, int num);
}
