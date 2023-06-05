package com.pawfor.github.service;


import com.pawfor.github.model.RepositoryDto;
import com.pawfor.github.webclient.RepositoryClient;
import com.pawfor.github.webclient.dto.ResponseBranchDto;
import com.pawfor.github.webclient.dto.ResponseRepositoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GithubService {

    private final RepositoryClient gitHubClient;

    private List<ResponseRepositoryDto> getRepositories(String username) throws Exception {
       return List.of(gitHubClient.getUserRepositoriesHub(username));
    }

    private List<ResponseBranchDto> getBranches(String username, ResponseRepositoryDto responseRepositoryDto) {
        return List.of(gitHubClient.getBranchesOfRepository(username, responseRepositoryDto.getName()));
    }

    private Map<ResponseRepositoryDto, List<ResponseBranchDto>> getRepositoriesAndBranches(String username) throws Exception {
        Map<ResponseRepositoryDto, List<ResponseBranchDto>> repositoriesAndBranches = new HashMap<>();
        List<ResponseRepositoryDto> repositories = getRepositories(username);
        for(ResponseRepositoryDto obj: repositories) {
            repositoriesAndBranches.put(obj, getBranches(username, obj));
        }
        return repositoriesAndBranches;
    }

    public List<RepositoryDto> getGithub(String username) throws Exception {
        Map<ResponseRepositoryDto, List<ResponseBranchDto>> map = getRepositoriesAndBranches(username);
        List<RepositoryDto> repositories = new ArrayList<>();
        for (Map.Entry<ResponseRepositoryDto, List<ResponseBranchDto>> entry : map.entrySet()) {
            repositories.add(new RepositoryDto(
                    entry.getKey().getName(),
                    entry.getKey().getOwner().getLogin(),
                    entry.getValue()));
        }
        return repositories;
    }







}
