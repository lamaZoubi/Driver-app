package com.example.autobice.Utils;

import com.example.autobice.Retrofit.API;
import com.example.autobice.Retrofit.RetrofitClient;

import retrofit2.Retrofit;

public class NetworkOperation {
    public static final String BASE_URL="http://192.168.8.102:5000/";
//    public static final String BASE_URL="http://127.0.0.1/";
    public static API getAPi(){
        return RetrofitClient.getClient(BASE_URL).create(API.class);
    }
}
