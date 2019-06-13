package com.example.demoretrofit;


import com.example.demoretrofit.Data.Model.Example;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

import java.util.List;

public interface Service {

    @GET("users")
    Call<ResponseBody> getAnswers(@Header("Authorization") String header);

}
