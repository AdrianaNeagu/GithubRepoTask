package com.example.adriana.githubrepotask.model;

import com.google.gson.annotations.SerializedName;

public class Owner {

    @SerializedName("login")
    private String ownerLogin;

    @SerializedName("id")
    private String ownerId;

    public Owner(String ownerLogin, String ownerId) {
        this.ownerLogin = ownerLogin;
        this.ownerId = ownerId;
    }

    public String getOwnerLogin() {
        return ownerLogin;
    }

    public String getOwnerId() {
        return ownerId;
    }
}
