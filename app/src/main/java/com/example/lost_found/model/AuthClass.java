
package com.example.lost_found.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class AuthClass {

    @SerializedName("data")
    @Expose
    private AuthData data;

    public AuthData getData() {
        return data;
    }

    public void setData(AuthData authData) {
        this.data = authData;
    }

}
