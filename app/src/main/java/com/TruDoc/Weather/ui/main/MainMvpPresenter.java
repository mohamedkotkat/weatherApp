package com.TruDoc.Weather.ui.main;

import com.TruDoc.Weather.ui.base.MvpPresenter;

/**
 * Created on : Feb 11, 2019
 * Author     : AndroidWave
 */
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {
    void getOpenWeather5DaysData(double lat , double lng);
}
