package com.traz.exampleapp.presenter;

import android.os.Bundle;

import com.traz.exampleapp.other.App;
import com.traz.exampleapp.presenter.mappers.RatesMapper;
import com.traz.exampleapp.presenter.viewObject.Rate;
import com.traz.exampleapp.view.fragments.RateListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;

/**
 * Created by TRaz on 27.07.17.
 * Have to work
 */

public class RateListPresenter extends BasePresenter {

    private static final String BUNDLE_REPO_LIST_KEY = "BUNDLE_RATE_LIST_KEY";

    @Inject
    RatesMapper ratesMapper;

    private RateListView view;

    private List<Rate> rateList;

    @Inject
    public RateListPresenter() {

    }

    public RateListPresenter(RateListView view) {
        super();
        App.getComponent().inject(this);
        this.view = view;
    }

    public void onCreateView(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            rateList = (List<Rate>) savedInstanceState.getSerializable(BUNDLE_REPO_LIST_KEY);
        }
        if (isRepoListNotEmpty()) {
            view.showRateList(rateList);
        }

        updateList();
    }

    private void updateList() {
        Subscription subscription = model.getExchangeList()
                .map(ratesMapper)
                .subscribe(new Observer<List<Rate>>() {
                    @Override
                    public void onCompleted() {
                        
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Rate> list) {
                        if (list != null && !list.isEmpty()) {
                            rateList = list;
                            view.showRateList(list);
                        } else {
                            view.showEmptyList();
                        }
                    }
                });
        addSubscription(subscription);
    }

    private boolean isRepoListNotEmpty() {
        return (rateList != null && !rateList.isEmpty());
    }

    public void onSaveInstanceState(Bundle outState) {
        if (isRepoListNotEmpty()) {
            outState.putSerializable(BUNDLE_REPO_LIST_KEY, new ArrayList<>(rateList));
        }
    }
}