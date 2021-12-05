package com.dev.microservices.app.answers.controllers;

import com.dev.microservices.app.answers.models.entity.Answer;
import com.dev.microservices.app.answers.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnswerController {

    @Autowired
    private AnswerService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Iterable<Answer> answers) {
        Iterable<Answer> answersDB = service.saveAll(answers);
        return ResponseEntity.status(HttpStatus.CREATED).body(answersDB);
    }

    @GetMapping("/student/{studentId}/exam/{studentId}")
    public ResponseEntity<?> getAnswersByStudentByExam(@PathVariable Long studentId, @PathVariable Long examId) {
        Iterable<Answer> answers = service.findAnswerByStudentByExam(studentId, examId);
        return ResponseEntity.ok(answers);
    }

    @GetMapping("/student/{studentId}/exams-answered")
    public ResponseEntity<?> getExamsIdsWithAnswersStudent(@PathVariable Long studentId) {
        Iterable<Long> examIds = service.findExamsIdsWithAnswersByStudent(studentId);
        return ResponseEntity.ok(examIds);
    }

}
