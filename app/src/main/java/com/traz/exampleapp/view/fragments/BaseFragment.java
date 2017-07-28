package com.traz.exampleapp.view.fragments;

import android.support.v4.app.Fragment;

import com.traz.exampleapp.presenter.Presenter;

/**
 * Created by TRaz on 27.07.17.
 * Have to work
 */

public abstract class BaseFragment extends Fragment {

    protected abstract Presenter getPresenter();

    @Override
    public void onStop() {
        super.onStop();
        if (getPresenter() != null) {
            getPresenter().onStop();
        }
    }

}