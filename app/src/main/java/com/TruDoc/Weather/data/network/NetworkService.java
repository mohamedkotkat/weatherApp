package com.TruDoc.Weather.data.network;

import com.TruDoc.Weather.data.network.pojo.OpenWeather5Day;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkService {

//    @GET("feed.json")
//    Single<WrapperResponse<List<FeedItem>>> getFeedList();
//
//
//    @POST("login")
//    Single<WrapperResponse<UserProfile>> doLoginApiCall(@Body LoginRequest mRequest);

    @GET("forecast?type=accurate&units=metric")
    Single<OpenWeather5Day> getOpenWeatherData5days(@Query("appid") String appId, @Query("lat") double lat, @Query("lon") double lon);
}
