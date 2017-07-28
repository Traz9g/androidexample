package com.traz.exampleapp.other.di.view;

import com.traz.exampleapp.presenter.RateListPresenter;
import com.traz.exampleapp.view.fragments.RateListView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TRaz on 27.07.17.
 * Have to work
 */

@Module
public class ViewDynamicModule {

    private RateListView view;

    public ViewDynamicModule(RateListView view) {
        this.view = view;
    }

    @Provides
    RateListPresenter provideRepoListPresenter() {
        return new RateListPresenter(view);
    }
}