package com.example.demoretrofit;

public class Apiutils {

    public static final String BASE_URL = "https://gorest.co.in/public-api/";

    public static Service getService() {
        return RetrofitClient.getClient(BASE_URL).create(Service.class);
    }
}