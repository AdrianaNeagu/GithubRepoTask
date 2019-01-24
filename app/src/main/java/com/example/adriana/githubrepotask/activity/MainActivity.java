package com.example.adriana.githubrepotask.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.adriana.githubrepotask.R;
import com.example.adriana.githubrepotask.adapter.RepoAdapter;
import com.example.adriana.githubrepotask.model.RepoResponse;
import com.example.adriana.githubrepotask.model.Repository;
import com.example.adriana.githubrepotask.rest.ApiClient;
import com.example.adriana.githubrepotask.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RepoResponse repoResponse;
    private List<Repository> repositoryList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<RepoResponse> call = apiInterface.getAllRepositories();
        call.enqueue(new Callback<RepoResponse>() {
            @Override
            public void onResponse(Call<RepoResponse> call, Response<RepoResponse> response) {
                repoResponse = response.body();
                repositoryList = repoResponse.getRepoList();
                recyclerView.setAdapter(new RepoAdapter(repositoryList, context));
            }

            @Override
            public void onFailure(Call<RepoResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }
}
