package com.fdmgroup.ai_agent_resume_screening_system.controller;

import com.fdmgroup.ai_agent_resume_screening_system.service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/api/search")
    public String search(
            @RequestParam String query) {

        return searchService.search(query);
    }
}