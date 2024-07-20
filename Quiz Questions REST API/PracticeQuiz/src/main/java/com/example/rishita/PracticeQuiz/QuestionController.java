package com.example.rishita.PracticeQuiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionservice;

    @GetMapping("allQuestion")
    public List<Question> allQuestion(){
        return questionservice.allQuestion();
    }

    @PostMapping("addQuestion")
    public Question addQuestion(@RequestBody Question question){
        return questionservice.addQuestion(question);
    }

    @GetMapping("level/{diff}")
    public List<Question> getQuestionByDifficultyLevel(@PathVariable("diff") String difficultylevel ){
        return questionservice.getQuestionByDifficultyLevel(difficultylevel);
    }

    @GetMapping("cat/{cat}")
    public List<Question> getQuestionByCategory(@PathVariable("cat") String category){
        return questionservice.getQuestionByCategory(category);
    }
    @GetMapping("sort")
    public List<Question> getQuestionBySortedId(){
        return questionservice.getQuestionBySortedId();
    }

    @PutMapping("update")
    public String updateQuestion(@RequestBody Question question){
        return questionservice.updateQuestion(question);
    }

    @DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        return questionservice.deleteById(id);
    }

    @GetMapping("keyword/{keyword}")
    public ResponseEntity<Object> getByKeyword(@PathVariable String keyword){
        return questionservice.getByKeyword(keyword, keyword);
    }




}
