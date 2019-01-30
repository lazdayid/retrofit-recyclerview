package com.lazday.retrofit.network;

import com.lazday.retrofit.main.MainModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("movie/popular")
    Call<MainModel> getPopular(
            @Query("api_key") String key,
            @Query("language") String language,
            @Query("page") String page );
}
