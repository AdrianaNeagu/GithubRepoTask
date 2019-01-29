package com.example.adriana.githubrepotask.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.widget.TextView;

import com.example.adriana.githubrepotask.R;
import com.example.adriana.githubrepotask.model.Readme;
import com.example.adriana.githubrepotask.model.RepoResponse;
import com.example.adriana.githubrepotask.model.Repository;
import com.example.adriana.githubrepotask.rest.ApiClient;
import com.example.adriana.githubrepotask.rest.ApiInterface;

import java.nio.charset.StandardCharsets;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryDetails extends AppCompatActivity {

    private TextView userTv;
    private TextView forksTv;
    private TextView watchersTv;
    private TextView repoNameTv;
    private TextView repoUrlTv;
    private TextView readmeTv;

    private String user = "";
    private String forks = "";
    private String watchers = "";
    private String repoName = "";
    private String repoUrl = "";
    private String readme = "";

    Repository repository;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_details);

        userTv = findViewById(R.id.repo_owner_tv);
        forksTv = findViewById(R.id.repo_forks_tv);
        watchersTv = findViewById(R.id.repo_watchers_tv);
        repoNameTv = findViewById(R.id.repo_name_tv);
        repoUrlTv = findViewById(R.id.repo_url_tv);
        readmeTv = findViewById(R.id.readme_tv);

        if(getIntent().hasExtra("repo")) {
            repository = getIntent().getExtras().getParcelable("repo");
        }

        userTv.setText(repository.getRepoOwner().getOwnerLogin());
        forksTv.setText(repository.getRepoForks());
        watchersTv.setText(repository.getRepoWatchers());
        repoNameTv.setText(repository.getRepoName());
        repoUrlTv.setText(repository.getRepoUrl());

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Readme> call = apiInterface.getReadmeFile(user, repoName);
        call.enqueue(new Callback<Readme>() {
            @Override
            public void onResponse(Call<Readme> call, Response<Readme> response) {
                String responseReadme = response.body().getReadme();
                readme = convertToString(responseReadme);
                readmeTv.setText(readme);
            }

            @Override
            public void onFailure(Call<Readme> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    private String convertToString(String base64) {
        byte[] data = Base64.decode(base64, Base64.DEFAULT);
        return new String(data, StandardCharsets.UTF_8);
    }

}
