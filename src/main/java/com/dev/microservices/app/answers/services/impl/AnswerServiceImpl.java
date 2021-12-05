package com.dev.microservices.app.answers.services.impl;

import com.dev.microservices.app.answers.models.entity.Answer;
import com.dev.microservices.app.answers.repository.AnswerRepository;
import com.dev.microservices.app.answers.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository repository;

    @Override
    @Transactional
    public Iterable<Answer> saveAll(Iterable<Answer> answers) {
        return repository.saveAll(answers);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Answer> findAnswerByStudentByExam(Long studentId, Long examId) {
        return repository.findAnswerByStudentByExam(studentId, examId);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Long> findExamsIdsWithAnswersByStudent(Long studentId) {
        return repository.findExamsIdsWithAnswersByStudent(studentId);
    }
}
