package com.example.lost_found.retrofit;

import com.example.lost_found.model.AddBarangResponse;
import com.example.lost_found.model.AuthClass;
import com.example.lost_found.model.ClaimResponse;
import com.example.lost_found.model.ListBarangObject;
import com.example.lost_found.model.ProfileResponse;
import com.example.lost_found.model.RegisResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface PortalClient {

    //EndPoin Login
    @FormUrlEncoded
    @POST("api/login")
    Call<AuthClass> checkLogin(@Field("username") String username, @Field("password") String password);

    @GET("api/barang")
    Call<ListBarangObject> getBarang(@Header("Authorization") String tokenb);

    //EndPoin Regis
    @FormUrlEncoded
    @POST("api/register")
    Call<RegisResponse> daftarRegis(@Field("nama") String nama,
                                    @Field("email") String email,
                                    @Field("password") String password,
                                    @Field("kontak") String kontak);

    //Endpoin add Barang
    @FormUrlEncoded
    @POST("api/addbarang")
    Call<AddBarangResponse> addBarang(@Field("nama_barang") String namaB,
                                      @Field("deskripsi") String dskripsiB,
                                      @Field("lokasi") String lokasiB,
                                      @Field("id_penemu") int i_userr);

    //Endpoin Claim Barang
    @FormUrlEncoded
    @POST("api/claimbarang")
    Call<ClaimResponse> claimBarang(@Field("id") String id_barang);

    //Enpoin Profile
    @FormUrlEncoded
    @POST("api/profile")
    Call<ProfileResponse> getProfile(@Field("token") String token);

}
