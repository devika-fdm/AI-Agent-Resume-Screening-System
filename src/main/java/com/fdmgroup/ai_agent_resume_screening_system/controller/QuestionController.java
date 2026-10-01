package com.fdmgroup.ai_agent_resume_screening_system.controller;

import com.fdmgroup.ai_agent_resume_screening_system.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(
            QuestionService questionService) {

        this.questionService = questionService;
    }

    @GetMapping("/api/questions")
    public String generateQuestions(
            @RequestParam String role) {

        return questionService.generateQuestions(role);
    }
}
