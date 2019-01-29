package com.example.adriana.githubrepotask.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Owner implements Parcelable {

    @SerializedName("login")
    private String ownerLogin;

    @SerializedName("id")
    private String ownerId;

    public Owner(String ownerLogin, String ownerId) {
        this.ownerLogin = ownerLogin;
        this.ownerId = ownerId;
    }

    protected Owner(Parcel in) {
        ownerLogin = in.readString();
        ownerId = in.readString();
    }

    public static final Creator<Owner> CREATOR = new Creator<Owner>() {
        @Override
        public Owner createFromParcel(Parcel in) {
            return new Owner(in);
        }

        @Override
        public Owner[] newArray(int size) {
            return new Owner[size];
        }
    };

    public String getOwnerLogin() {
        return ownerLogin;
    }

    public String getOwnerId() {
        return ownerId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ownerLogin);
        dest.writeString(ownerId);
    }
}
