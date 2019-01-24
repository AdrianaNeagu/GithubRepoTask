package com.example.adriana.githubrepotask.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RepoResponse {

    @SerializedName("total_count")
    private String totalCount;

    @SerializedName("items")
    private List<Repository> repoList;

    public RepoResponse(String totalCount, List<Repository> repoList) {
        this.totalCount = totalCount;
        this.repoList = repoList;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public List<Repository> getRepoList() {
        return repoList;
    }
}
