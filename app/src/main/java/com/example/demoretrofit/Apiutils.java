package com.example.demoretrofit;

public class Apiutils {

    public static final String BASE_URL = "https://gorest.co.in/public-api/users?_format=json&access-token=myoXKxq8KV1W6XvpVZvXjfeqcasoAMC8rLzu/";

    public static Service getService() {
        return RetrofitClient.getClient(BASE_URL).create(Service.class);
    }
}