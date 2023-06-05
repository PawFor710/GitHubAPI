package com.pawfor.github.webclient;

import com.pawfor.github.exception.UserNotFoundException;
import com.pawfor.github.webclient.dto.ResponseBranchDto;
import com.pawfor.github.webclient.dto.ResponseRepositoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@RequiredArgsConstructor
public class RepositoryClient {

    private static final String REPOSITORIES_URL = "https://api.github.com/users/";
    private static final String BRANCHES_URL = "https://api.github.com/repos/";
    private final RestTemplate restTemplate = new RestTemplate();


    public ResponseRepositoryDto[] getUserRepositoriesHub(String username) throws UserNotFoundException {
        return restTemplate.getForObject(REPOSITORIES_URL + "{username}/repos?fork=false",
                ResponseRepositoryDto[].class,
                username);
    }

    public ResponseBranchDto[] getBranchesOfRepository(String username, String repository) {
        return restTemplate.getForObject(BRANCHES_URL + "{username}/{repository}/branches",
                ResponseBranchDto[].class,
                username, repository);
    }
}
