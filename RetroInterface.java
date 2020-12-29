package com.tahmeedul.retrofitjustajson;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroInterface {

    @GET("comments")                                                // endpoints
    Call<List<MyModel>> getData(@Query("postId") int postId);       // @QUERY, you can use @PATH, @URL etc

}
