package com.example.adriana.githubrepotask.rest;

import com.example.adriana.githubrepotask.model.Readme;
import com.example.adriana.githubrepotask.model.RepoResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("search/repositories?q=topic:android&sort=stars&order=desc")
    Call<RepoResponse> getAllRepositories();

    @GET("repos/{user}/{repoName}/readme")
    Call<Readme> getReadmeFile(@Path("user") String user, @Path("repoName") String repoName);
}
