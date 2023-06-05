package com.pawfor.github.controller;

import com.pawfor.github.exception.UserNotFoundException;
import com.pawfor.github.model.RepositoryDto;
import com.pawfor.github.model.RequestUserDto;
import com.pawfor.github.service.GithubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/github")
public class GithubController {

    private final GithubService gitHubService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RepositoryDto>> getGitHub(@RequestBody RequestUserDto request) throws UserNotFoundException {
        return ResponseEntity.ok(gitHubService.getGithub(request.getLogin()));
    }

}
