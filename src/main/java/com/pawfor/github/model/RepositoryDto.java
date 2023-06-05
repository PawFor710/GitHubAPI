package com.pawfor.github.model;

import com.pawfor.github.webclient.dto.OwnerDto;
import com.pawfor.github.webclient.dto.ResponseBranchDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryDto {

    private String repositoryName;
    private String ownerLogin;
    private List<ResponseBranchDto> branches;

}
