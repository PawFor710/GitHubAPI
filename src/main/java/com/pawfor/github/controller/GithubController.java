package com.pawfor.github.controller;

import com.pawfor.github.model.RepositoryDto;
import com.pawfor.github.service.GithubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/github")
public class GithubController {

    private final GithubService gitHubService;

    @GetMapping("/{login}")
    public ResponseEntity<List<RepositoryDto>> getGitHub(@PathVariable String login) throws Exception  {
            return ResponseEntity.ok(gitHubService.getGithub(login));
    }

}
