package com.fdmgroup.ai_agent_resume_screening_system.controller;

import com.fdmgroup.ai_agent_resume_screening_system.service.ResumeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("/test")
    public String test() {
        return "Resume Screening System Running";
    }

    @PostMapping("/upload")
    public String uploadResume(@RequestParam("file") MultipartFile file) {
        return resumeService.uploadResume(file);
    }
}