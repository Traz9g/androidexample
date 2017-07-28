package com.traz.exampleapp.view.fragments;

import com.traz.exampleapp.presenter.viewObject.Rate;

import java.util.List;

/**
 * Created by TRaz on 27.07.17.
 * Have to work
 */

public interface RateListView extends View {

    void showRateList(List<Rate> rates);

    void showEmptyList();
}