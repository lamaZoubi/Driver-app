package com.example.autobice.Retrofit;

import com.example.autobice.Models.LoginMessage;
import com.example.autobice.Models.RegisterMessage;
import com.example.autobice.Models.SigupMessage;
import com.example.autobice.Utils.NetworkOperation;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {

    @FormUrlEncoded
    @POST("user")
    Call<SigupMessage> signUp(@FieldMap Map<String, String> params);



    @FormUrlEncoded
    @POST("machine")
    Call<RegisterMessage> SaveMachine(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("login")
    Call<LoginMessage> login (@FieldMap Map<String, String> params);
}
