package com.gdsc.homework;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

import com.gdsc.homework.model.BasicResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public interface RESTApi {
    @Headers(value = "Content-Type: application/json")

    @POST("api/auth/google/login")
    Call<BasicResponse> googleLogin(
            @Body String idToken);

    Gson gson = new GsonBuilder().setLenient().create();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://ec2-3-38-185-14.ap-northeast-2.compute.amazonaws.com:8081/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
}
