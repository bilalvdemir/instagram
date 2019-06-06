package com.example.bilal.instagram.client;

import com.example.bilal.instagram.model.media.MediaResponse;
import com.example.bilal.instagram.model.self.UserSelf;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestInterface {

    @GET("v1/users/self/media/recent")
    Call<MediaResponse> getMediaRecent(@Query("access_token") String token);

    @GET("v1/users/self")
    Call<UserSelf> getUserInfoSelf(@Query("access_token") String token);

    @GET("v1/users/self/follows")
    Call<Object> getUserFollows(@Query("access_token") String token);
}
