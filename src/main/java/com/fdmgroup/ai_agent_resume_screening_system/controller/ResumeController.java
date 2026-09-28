package com.fdmgroup.ai_agent_resume_screening_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResumeController {

    @GetMapping("/test")
    public String test() {
        return "Resume Screening System Running";
    }
}