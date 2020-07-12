package com.TruDoc.Weather.ui.main;

import com.TruDoc.Weather.data.network.pojo.OpenWeather5Day;
import com.TruDoc.Weather.ui.base.MvpView;

/**
 * Created on : Feb 11, 2019
 * Author     : AndroidWave
 */
public interface MainMvpView extends MvpView {
    void updateView(OpenWeather5Day objOpenWeather5Day);
}
