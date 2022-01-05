package com.example.lost_found.retrofit;

import com.example.lost_found.model.AuthClass;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PortalClient {

    //EndPoin Login
    @FormUrlEncoded
    @POST("api/login")
    Call<AuthClass> checkLogin(@Field("username") String username, @Field("password") String password);

}
