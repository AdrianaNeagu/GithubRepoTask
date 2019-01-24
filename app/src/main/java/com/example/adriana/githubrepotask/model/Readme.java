package com.example.adriana.githubrepotask.model;

import com.google.gson.annotations.SerializedName;

public class Readme {

    @SerializedName("content")
    private String readme;

    public Readme(String readme) {
        this.readme = readme;
    }

    public String getReadme() {
        return readme;
    }
}
