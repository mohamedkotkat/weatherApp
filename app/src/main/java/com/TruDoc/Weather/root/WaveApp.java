package com.TruDoc.Weather.root;

import android.app.Application;

import com.TruDoc.Weather.di.component.ApplicationComponent;
import com.TruDoc.Weather.di.component.DaggerApplicationComponent;
import com.TruDoc.Weather.di.module.ApplicationModule;

/**
 * Created on : Jan 19, 2019
 * Author     : AndroidWave
 * Email    : info@androidwave.com
 */
public class WaveApp extends Application {


    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
        mApplicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
