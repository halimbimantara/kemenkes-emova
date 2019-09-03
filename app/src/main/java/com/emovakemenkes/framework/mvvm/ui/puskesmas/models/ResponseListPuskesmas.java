package com.emovakemenkes.framework.mvvm.ui.puskesmas.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public  class ResponseListPuskesmas {

    @Expose
    @SerializedName("results")
    private List<ModelListPuskesmas> results;
    @Expose
    @SerializedName("total")
    private String total;
    @Expose
    @SerializedName("message")
    private String message;
    @Expose
    @SerializedName("status")
    private boolean status;

    public List<ModelListPuskesmas> getResults() {
        return results;
    }

    public void setResults(List<ModelListPuskesmas> results) {
        this.results = results;
    }

    public boolean isStatus() {
        return status;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
