package com.example.demoretrofit;


import com.example.demoretrofit.Data.Model.Example;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface Service {

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<Example> getAnswers();

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<Example> getAnswers(@Query("tagged") String tags);
}
