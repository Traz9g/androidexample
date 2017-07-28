package com.traz.exampleapp.other.di;

import com.traz.exampleapp.model.ModelImpl;
import com.traz.exampleapp.presenter.BasePresenter;
import com.traz.exampleapp.presenter.RateListPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by TRaz on 27.07.17.
 * Have to work
 */

@Singleton
@Component(modules = {ModelModule.class, PresenterModule.class})
public interface AppComponent {

    void inject(ModelImpl dataRepository);

    void inject(BasePresenter basePresenter);

    void inject(RateListPresenter rateListPresenter);
}