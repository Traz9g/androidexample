package com.traz.exampleapp.view.adapters;

import com.traz.exampleapp.presenter.viewObject.Rate;

import java.util.List;

/**
 * Created by TRaz on 27.07.17.
 * Have to work
 */

public class RateAdapter extends BaseAdapter<Rate> {
    public RateAdapter(List<Rate> list) {
        super(list);
    }

    @Override
    public void onBindViewHolder(BaseAdapter.ViewHolder viewHolder, int i) {
        Rate repo = list.get(i);
        viewHolder.typeTv.setText(repo.getName());
        viewHolder.valueTv.setText(String.valueOf(repo.getRateValue()));
    }

    public void setRateList(List<Rate> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}