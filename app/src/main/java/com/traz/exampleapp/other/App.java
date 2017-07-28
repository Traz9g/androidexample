package com.traz.exampleapp.other;

import android.app.Application;

import com.traz.exampleapp.other.di.AppComponent;
import com.traz.exampleapp.other.di.DaggerAppComponent;

/**
 * Created by TRaz on 27.07.17.
 * Have to work
 */

public class App extends Application {
    private static AppComponent component;

    public static AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = buildComponent();
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .build();
    }
}