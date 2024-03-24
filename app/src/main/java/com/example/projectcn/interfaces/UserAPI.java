package com.example.projectcn.interfaces;

import com.example.projectcn.model.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserAPI {
    @POST("user/login")
    Call<ResponseBody> loginUser(@Body User user);
    @POST("user/register")
    Call<ResponseBody> registerUser(@Body User user);
    @GET("user/{id}")
    Call<User> getUserById(@Path("id") String username);
    @GET("user/send_email")
    Call<String> sendResetPasswordEmail(@Query("username") String username, @Query("email") String email);
    @PUT("user/reset_password")
    Call<String> resetPassword(@Query("email") String email, @Query("resetCode") String resetCode, @Query("newPassword") String newPassword);

}
