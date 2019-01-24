package com.example.adriana.githubrepotask.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.widget.TextView;

import com.example.adriana.githubrepotask.R;
import com.example.adriana.githubrepotask.model.Readme;
import com.example.adriana.githubrepotask.model.RepoResponse;
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

        getIncomingIntent();

        userTv.setText(user);
        forksTv.setText(forks);
        watchersTv.setText(watchers);
        repoNameTv.setText(repoName);
        repoUrlTv.setText(repoUrl);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Readme> call = apiInterface.getReadmeFile(user, repoName);
        call.enqueue(new Callback<Readme>() {
            @Override
            public void onResponse(Call<Readme> call, Response<Readme> response) {
                String responseReadme = response.body().toString();
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

    public void getIncomingIntent() {
        if (getIntent().hasExtra("user") && getIntent().hasExtra("forks")
                && getIntent().hasExtra("watchers") && getIntent().hasExtra("repoName")
                && getIntent().hasExtra("repoUrl")) {
            user = getIntent().getStringExtra("user");
            forks = getIntent().getStringExtra("forks");
            watchers = getIntent().getStringExtra("watchers");
            repoName = getIntent().getStringExtra("repoName");
            repoUrl = getIntent().getStringExtra("repoUrl");
        }
    }


}
