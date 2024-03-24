package com.example.projectcn.interfaces;

import com.example.projectcn.model.TotalQuestionsScore;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TotalQuestionsScoreAPI {
    @POST("totalScore/save")
    Call<ResponseBody> saveTotalScore(@Body TotalQuestionsScore totalScore);

    @GET("totalScore/getUserId/{userId}")
    Call<List<TotalQuestionsScore>> getTotalScoresByUserId(@Path("userId") Long userId);
}
