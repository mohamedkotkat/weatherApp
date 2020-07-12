package com.TruDoc.Weather.di.component;


import com.TruDoc.Weather.di.PerActivity;
import com.TruDoc.Weather.di.module.ActivityModule;
import com.TruDoc.Weather.ui.Details.DetailsActivity;

import com.TruDoc.Weather.ui.main.MainActivity;

import dagger.Component;

/**
 * Created on : Jan 19, 2019
 * Author     : AndroidWave
 * Email    : info@androidwave.com
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {




    void inject(MainActivity mainActivity);
    void inject(DetailsActivity mainActivity);
}