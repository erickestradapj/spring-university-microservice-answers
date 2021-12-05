package com.dev.microservices.app.answers.repository;

import com.dev.microservices.app.answers.models.entity.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> {

    @Query("SELECT a FROM Answer a JOIN FETCH a.student s JOIN FETCH  a.question q JOIN FETCH q.exam e WHERE s.id=?1 GROUP BY e.id")
    Iterable<Answer> findAnswerByStudentByExam(Long studentId, Long examId);

    @Query("SELECT e.id FROM Answer  a JOIN a.student s JOIN a.question q JOIN  q.exam e WHERE e.id=?1 GROUP BY e.id")
    Iterable<Long> findExamsIdsWithAnswersByStudent(Long studentId);
}
