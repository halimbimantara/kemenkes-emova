package com.emovakemenkes.framework.mvvm.data.model.api.emova.main.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class LoginRequestEmova {
    @Expose
    @SerializedName("username")
    private String Username;
    @Expose
    @SerializedName("password")
    private String Password;
    @Expose
    @SerializedName("firebaseid")
    private String FirebaseID;

    public LoginRequestEmova(String username, String password, String firebaseID) {
        Username = username;
        Password = password;
        FirebaseID = firebaseID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getFirebaseID() {
        return FirebaseID;
    }

    public void setFirebaseID(String firebaseID) {
        FirebaseID = firebaseID;
    }
}
