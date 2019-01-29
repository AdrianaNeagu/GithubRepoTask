package com.example.adriana.githubrepotask.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Repository implements Parcelable {

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

    protected Repository(Parcel in) {
        repoId = in.readString();
        repoName = in.readString();
        repoUrl = in.readString();
        repoForks = in.readString();
        repoWatchers = in.readString();
    }

    public static final Creator<Repository> CREATOR = new Creator<Repository>() {
        @Override
        public Repository createFromParcel(Parcel in) {
            return new Repository(in);
        }

        @Override
        public Repository[] newArray(int size) {
            return new Repository[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(repoId);
        dest.writeString(repoName);
        dest.writeString(repoUrl);
        dest.writeString(repoForks);
        dest.writeString(repoWatchers);
    }
}
