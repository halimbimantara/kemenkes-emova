package com.emovakemenkes.framework.mvvm.data.model.api.emova.main.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginResponseEmova {
    @Expose
    @SerializedName("data")
    public List<Data> data;
    @Expose
    @SerializedName("message")
    public String message;
    @Expose
    @SerializedName("status")
    public boolean status;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static class Data {
        @Expose
        @SerializedName("session_nama_lengkap")
        public String session_nama_lengkap;
        @Expose
        @SerializedName("session_username")
        public String session_username;
        @Expose
        @SerializedName("session_id_user_group")
        public String session_id_user_group;
        @Expose
        @SerializedName("session_id_users")
        public String session_id_users;
        @Expose
        @SerializedName("kd_prov")
        public String kd_prov;
        @Expose
        @SerializedName("kd_kabkot")
        public String kd_kabkot;

        public String getKd_prov() {
            return kd_prov;
        }

        public void setKd_prov(String kd_prov) {
            this.kd_prov = kd_prov;
        }

        public String getKd_kabkot() {
            return kd_kabkot;
        }

        public void setKd_kabkot(String kd_kabkot) {
            this.kd_kabkot = kd_kabkot;
        }

        public String getSession_nama_lengkap() {
            return session_nama_lengkap;
        }

        public void setSession_nama_lengkap(String session_nama_lengkap) {
            this.session_nama_lengkap = session_nama_lengkap;
        }

        public String getSession_username() {
            return session_username;
        }

        public void setSession_username(String session_username) {
            this.session_username = session_username;
        }

        public String getSession_id_user_group() {
            return session_id_user_group;
        }

        public void setSession_id_user_group(String session_id_user_group) {
            this.session_id_user_group = session_id_user_group;
        }

        public String getSession_id_users() {
            return session_id_users;
        }

        public void setSession_id_users(String session_id_users) {
            this.session_id_users = session_id_users;
        }
    }
}
