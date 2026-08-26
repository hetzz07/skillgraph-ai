package com.skillgraph.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.skillgraph.dto.GitHubResponse;
import com.skillgraph.service.GitHubService;

@RestController
public class GitHubController {

    private final GitHubService gitHubService;

    public GitHubController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping("/api/github/{username}")
    public GitHubResponse analyzeGitHub(@PathVariable String username) {

        return gitHubService.analyzeGitHub(username);

    }

}