package com.example.rishita.PracticeQuiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo questionrepo;
    public List<Question> allQuestion() {
        return questionrepo.findAll();
    }

    public Question addQuestion(Question question) {
        return questionrepo.save(question);
    }



    public List<Question> getQuestionByDifficultyLevel(String difficultylevel) {
        return questionrepo.findByDifficultylevel(difficultylevel);
    }

    public List<Question> getQuestionByCategory(String category) {
        return questionrepo.findByCategory(category);
    }

    public List<Question> getQuestionBySortedId() {
        return questionrepo.findBySortedId();
    }

    public String updateQuestion(Question question) {
        try{
            List<Question> all = questionrepo.findAll();
            if(all.isEmpty()){
                questionrepo.save(question);
                return "Success";
            }
            Integer k = question.getId();
            for(Question que: all){
                if(que.getId().equals(k)){
                    questionrepo.save(question);
                    return "Success";
                }
            }
            return "This Question not avaliable";
        }
        catch(Exception e){
            return "No Update Question";
        }
    }

    public String deleteById(Integer id) {
        try{
            List<Question> all = questionrepo.findAll();
            if(all.isEmpty()){
                return "Empty List cannot delete";
            }
            for(Question k : all){
                if(k.getId().equals(id)){
                    questionrepo.deleteById(id);
                    return "Success";
                }
            }
            return "Failed";
        }
        catch(Exception e){
            return "Exception occur";
        }
    }


    public ResponseEntity<Object> getByKeyword(String keyword, String keyword1) {
        try{
            List<Question> k = questionrepo.findByQuestiontitleContainingIgnoreCaseOrRightanswerContainingIgnoreCase(keyword,keyword);
            if(k.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(400);
            }
            return ResponseEntity.ok(k);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(400);
        }
    }
}
