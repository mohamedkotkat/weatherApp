package com.TruDoc.Weather.data.network;

import com.TruDoc.Weather.data.network.pojo.OpenWeather5Day;

import io.reactivex.Single;

public interface RestApiHelper {

//    Single<WrapperResponse<UserProfile>> doLoginApiCall(LoginRequest request);
//
//    Single<WrapperResponse<List<FeedItem>>> getFeedList();

    Single<OpenWeather5Day> getOpenWeatherData5days( double lat,  double lon);
}
