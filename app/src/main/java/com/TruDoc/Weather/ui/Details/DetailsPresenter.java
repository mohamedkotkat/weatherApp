package com.TruDoc.Weather.ui.Details;

import com.TruDoc.Weather.data.DataManager;
import com.TruDoc.Weather.ui.base.BasePresenter;
import com.TruDoc.Weather.ui.main.MainMvpPresenter;
import com.TruDoc.Weather.ui.main.MainMvpView;
import com.TruDoc.Weather.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

public class DetailsPresenter <V extends DetailsMvpView> extends BasePresenter<V>
        implements DetailsMvpPresenter<V> {
    public DetailsPresenter(DataManager manager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(manager, schedulerProvider, compositeDisposable);
    }
}
