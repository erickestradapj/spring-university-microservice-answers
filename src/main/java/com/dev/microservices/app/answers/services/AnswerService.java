package com.dev.microservices.app.answers.services;

import com.dev.microservices.app.answers.models.entity.Answer;

public interface AnswerService {

    Iterable<Answer> saveAll(Iterable<Answer> answers);

    Iterable<Answer> findAnswerByStudentByExam(Long studentId, Long examId);

    Iterable<Long> findExamsIdsWithAnswersByStudent(Long studentId);
}
