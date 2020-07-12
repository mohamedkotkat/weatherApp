package com.TruDoc.Weather.di.module;

import android.content.Context;

import com.TruDoc.Weather.data.network.pojo.DetailsItem;
import com.TruDoc.Weather.data.network.pojo.OpenWeather5Day;
import com.TruDoc.Weather.di.ActivityContext;
import com.TruDoc.Weather.di.PerActivity;
import com.TruDoc.Weather.ui.Details.DetailsAdapter;
import com.TruDoc.Weather.ui.Details.DetailsMvpPresenter;
import com.TruDoc.Weather.ui.Details.DetailsMvpView;
import com.TruDoc.Weather.ui.Details.DetailsPresenter;

import com.TruDoc.Weather.ui.main.MainAdapter;
import com.TruDoc.Weather.ui.main.MainMvpPresenter;
import com.TruDoc.Weather.ui.main.MainMvpView;
import com.TruDoc.Weather.ui.main.MainPresenter;
import com.TruDoc.Weather.utils.rx.AppSchedulerProvider;
import com.TruDoc.Weather.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created on : Jan 19, 2019
 * Author     : AndroidWave
 * Email    : info@androidwave.com
 */
@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }


    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }





    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    DetailsMvpPresenter<DetailsMvpView> provideDetailsPresenter(DetailsPresenter<DetailsMvpView> presenter) {
        return presenter;
    }


    @Provides
    MainAdapter provideRssAdapter() {
        return new MainAdapter(new  ArrayList<OpenWeather5Day.List>());
    }
    @Provides
    DetailsAdapter provideDetailsAdapter() {
        return new DetailsAdapter(new  ArrayList<DetailsItem>());
    }
}