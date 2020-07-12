package com.TruDoc.Weather.data.network;

import com.TruDoc.Weather.BuildConfig;
import com.TruDoc.Weather.data.network.pojo.OpenWeather5Day;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class RestApiManager implements RestApiHelper {

    NetworkService mService;

    @Inject
    public RestApiManager(NetworkService apiService) {
        mService = apiService;
    }

    //    @Override
//    public Single<WrapperResponse<UserProfile>> doLoginApiCall(LoginRequest request) {
//        return mService.doLoginApiCall(request);
//    }
//
//    @Override
//    public Single<WrapperResponse<List<FeedItem>>> getFeedList() {
//        return mService.getFeedList();
//    }
    @Override
    public Single<OpenWeather5Day> getOpenWeatherData5days(double lat,  double lon) {
        return mService.getOpenWeatherData5days(BuildConfig.API_KEY,lat,lon);
}


}
