package com.traz.exampleapp.other.di.view;

import com.traz.exampleapp.view.fragments.RateListFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by TRaz on 27.07.17.
 * Have to work
 */

@Singleton
@Component(modules = {ViewDynamicModule.class})
public interface ViewComponent {

    void inject(RateListFragment repoListFragment);
}