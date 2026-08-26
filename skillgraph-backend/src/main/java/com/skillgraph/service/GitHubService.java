package com.skillgraph.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.skillgraph.dto.GitHubResponse;

@Service
public class GitHubService {

    private final RestTemplate restTemplate = new RestTemplate();

    public GitHubResponse analyzeGitHub(String username) {

        String url = "https://api.github.com/users/" + username;

        Map<String, Object> user =
                restTemplate.getForObject(url, Map.class);

        GitHubResponse response = new GitHubResponse();

        response.setUsername((String) user.get("login"));
        response.setAvatarUrl((String) user.get("avatar_url"));
        response.setRepositories((Integer) user.get("public_repos"));
        response.setFollowers((Integer) user.get("followers"));
        response.setFollowing((Integer) user.get("following"));

        // Temporary language list
        response.setLanguages(Arrays.asList(
                "Java",
                "Spring Boot",
                "Angular"
        ));

        // Simple GitHub Score
        int score = 50;

        score += response.getRepositories();
        score += response.getFollowers();

        if (score > 100) {
            score = 100;
        }

        response.setGithubScore(score);

        List<String> suggestions = new ArrayList<>();

        suggestions.add("Improve README");
        suggestions.add("Add Unit Tests");
        suggestions.add("Use Docker");
        suggestions.add("Add Spring Security");

        response.setSuggestions(suggestions);

        return response;
    }
}