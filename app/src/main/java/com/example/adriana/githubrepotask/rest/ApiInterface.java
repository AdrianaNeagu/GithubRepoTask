package com.example.adriana.githubrepotask.rest;

import com.example.adriana.githubrepotask.model.RepoResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("repositories?q=topic:android&sort=stars&order=desc")
    Call<RepoResponse> getAllRepositories();


}
