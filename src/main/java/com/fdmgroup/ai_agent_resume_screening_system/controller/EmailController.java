package com.fdmgroup.ai_agent_resume_screening_system.controller;

import com.fdmgroup.ai_agent_resume_screening_system.service.EmailService;
import com.fdmgroup.ai_agent_resume_screening_system.service.QuestionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final QuestionService questionService;
    private final EmailService emailService;
    

    public EmailController(
            QuestionService questionService,
            EmailService emailService) {

        this.questionService = questionService;
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public String sendQuestions(
            @RequestParam String role,
            @RequestParam String email) {

        String questions =
                questionService.generateQuestions(role);

        emailService.sendEmail(
                email,
                "Interview Questions - " + role,
                questions);

        return "Interview questions emailed successfully";
    }
}
