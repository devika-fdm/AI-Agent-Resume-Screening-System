package com.fdmgroup.ai_agent_resume_screening_system.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private final ChatClient chatClient;

    public QuestionService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String generateQuestions(String role) {

        return chatClient.prompt()
                .user("""
                        Generate 10 interview questions
                        for a %s candidate.

                        Include:
                        - Technical questions
                        - Scenario questions
                        - Behavioural questions
                        """
                        .formatted(role))
                .call()
                .content();
    }
}