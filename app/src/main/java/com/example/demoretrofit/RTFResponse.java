package com.example.demoretrofit;

import com.example.demoretrofit.Data.Model.Result;
import com.google.gson.annotations.SerializedName;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Header;

public interface RTFResponse extends Service {
    @SerializedName("result")

    Call< List<Result>> getLstresul(@Header("Authorization") String header);
}
