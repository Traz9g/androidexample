package com.traz.exampleapp.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.traz.exampleapp.R;
import com.traz.exampleapp.other.di.view.DaggerViewComponent;
import com.traz.exampleapp.other.di.view.ViewComponent;
import com.traz.exampleapp.other.di.view.ViewDynamicModule;
import com.traz.exampleapp.presenter.BasePresenter;
import com.traz.exampleapp.presenter.RateListPresenter;
import com.traz.exampleapp.presenter.viewObject.Rate;
import com.traz.exampleapp.view.adapters.RateAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by TRaz on 27.07.17.
 * Have to work
 */

public class RateListFragment extends BaseFragment implements RateListView {

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    @Inject
    RateListPresenter presenter;

    private RateAdapter adapter;

    private ViewComponent viewComponent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (viewComponent == null) {
            viewComponent = DaggerViewComponent.builder()
                    .viewDynamicModule(new ViewDynamicModule(this))
                    .build();
        }
        viewComponent.inject(this);
    }

    public void setViewComponent(ViewComponent viewComponent) {
        this.viewComponent = viewComponent;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rate_list, container, false);
        ButterKnife.bind(this, view);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);
        adapter = new RateAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        presenter.onCreateView(savedInstanceState);

        return view;
    }

    private void makeToast(String text) {
        Snackbar.make(recyclerView, text, Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected BasePresenter getPresenter() {
        return presenter;
    }


    @Override
    public void showError(String error) {
        makeToast(error);
    }

    @Override
    public void showRateList(List<Rate> rateList) {
        adapter.setRateList(rateList);
    }

    @Override
    public void showEmptyList() {
        makeToast(getActivity().getString(R.string.empty_list));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }
}