package com.example.rishita.PracticeQuiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {


    List<Question> findByDifficultylevel(String difficultylevel);
    List<Question> findByCategory(String category);
    @Query("from Question order by id asc")
    List<Question> findBySortedId();

    

    List<Question> findByQuestiontitleContainingIgnoreCaseOrRightanswerContainingIgnoreCase(String keyword, String keyword1);
}
