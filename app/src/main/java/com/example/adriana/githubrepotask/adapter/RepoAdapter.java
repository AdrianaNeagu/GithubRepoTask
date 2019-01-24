package com.example.adriana.githubrepotask.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.adriana.githubrepotask.R;
import com.example.adriana.githubrepotask.activity.MainActivity;
import com.example.adriana.githubrepotask.activity.RepositoryDetails;
import com.example.adriana.githubrepotask.model.Repository;

import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder> {

    private List<Repository> repositoryList;
    private Context context;

    public RepoAdapter(List<Repository> transactionList, Context context) {
        this.repositoryList = transactionList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_repo, viewGroup, false);
        context = viewGroup.getContext();
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final Repository repository = repositoryList.get(i);
        viewHolder.repoName.setText(repository.getRepoName());
        viewHolder.repoId.setText(repository.getRepoId());
        viewHolder.repoStars.setText(repository.getRepoWatchers());

        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RepositoryDetails.class);
                intent.putExtra("user", repository.getRepoOwner().getOwnerLogin());
                intent.putExtra("forks", repository.getRepoForks());
                intent.putExtra("watchers", repository.getRepoWatchers());
                intent.putExtra("repoName", repository.getRepoName());
                intent.putExtra("repoUrl", repository.getRepoUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return repositoryList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView repoName;
        TextView repoId;
        TextView repoStars;
        LinearLayout linearLayout;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            repoName = itemView.findViewById(R.id.repo_name_tv);
            repoId = itemView.findViewById(R.id.repo_id_tv);
            repoStars = itemView.findViewById(R.id.repo_stars_tv);
            linearLayout = itemView.findViewById(R.id.repo_item_list_layout);
        }
    }

}
