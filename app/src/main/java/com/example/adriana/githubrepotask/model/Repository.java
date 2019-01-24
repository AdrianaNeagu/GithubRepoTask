package com.example.adriana.githubrepotask.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Repository {

    @SerializedName("id")
    private String repoId;

    @SerializedName("name")
    private String repoName;

    @SerializedName("html_url")
    private String repoUrl;

    @SerializedName("forks")
    private String repoForks;

    @SerializedName("watchers")
    private String repoWatchers;

    @SerializedName("owner")
    private Owner repoOwner;

    public Repository(String repoId, String repoName, String repoUrl, String repoForks, String repoWatchers, Owner repoOwner) {
        this.repoId = repoId;
        this.repoName = repoName;
        this.repoUrl = repoUrl;
        this.repoForks = repoForks;
        this.repoWatchers = repoWatchers;
        this.repoOwner = repoOwner;
    }

    public String getRepoId() {
        return repoId;
    }

    public String getRepoName() {
        return repoName;
    }

    public String getRepoUrl() {
        return repoUrl;
    }

    public String getRepoForks() {
        return repoForks;
    }

    public String getRepoWatchers() {
        return repoWatchers;
    }

    public Owner getRepoOwner() {
        return repoOwner;
    }
}
