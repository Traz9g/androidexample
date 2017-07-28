package com.traz.exampleapp.presenter.mappers;

import com.traz.exampleapp.model.dto.ExchangeDTO;
import com.traz.exampleapp.presenter.viewObject.Rate;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.functions.Func1;

/**
 * Created by TRaz on 27.07.17.
 * Have to work
 */

public class RatesMapper implements Func1<ExchangeDTO, List<Rate>> {

    @Inject
    public RatesMapper() {

    }

    @Override
    public List<Rate> call(ExchangeDTO exchangeDTO) {
        if (exchangeDTO == null) {
            return null;
        }

        List<Rate> rateList = new ArrayList<>();
        rateList.add(new Rate("AUD", exchangeDTO.getRates().getAUD()));
        rateList.add(new Rate("BGN", exchangeDTO.getRates().getBGN()));
        rateList.add(new Rate("BRL", exchangeDTO.getRates().getBRL()));
        rateList.add(new Rate("CAD", exchangeDTO.getRates().getCAD()));
        rateList.add(new Rate("CHF", exchangeDTO.getRates().getCHF()));
        rateList.add(new Rate("CNY", exchangeDTO.getRates().getCNY()));
        rateList.add(new Rate("CZK", exchangeDTO.getRates().getCNY()));
        rateList.add(new Rate("DKK", exchangeDTO.getRates().getDKK()));
        rateList.add(new Rate("GBP", exchangeDTO.getRates().getGBP()));
        rateList.add(new Rate("HKD", exchangeDTO.getRates().getHKD()));
        rateList.add(new Rate("HRK", exchangeDTO.getRates().getHRK()));
        rateList.add(new Rate("HUF", exchangeDTO.getRates().getHUF()));
        rateList.add(new Rate("IDR", exchangeDTO.getRates().getIDR()));
        rateList.add(new Rate("ILS", exchangeDTO.getRates().getILS()));
        rateList.add(new Rate("INR", exchangeDTO.getRates().getINR()));
        rateList.add(new Rate("JPY", exchangeDTO.getRates().getJPY()));
        rateList.add(new Rate("KRW", exchangeDTO.getRates().getKRW()));
        rateList.add(new Rate("MXN", exchangeDTO.getRates().getMXN()));
        rateList.add(new Rate("MYR", exchangeDTO.getRates().getMYR()));
        rateList.add(new Rate("NOK", exchangeDTO.getRates().getNOK()));
        rateList.add(new Rate("NZD", exchangeDTO.getRates().getNZD()));
        rateList.add(new Rate("PHP", exchangeDTO.getRates().getPHP()));
        rateList.add(new Rate("PLN", exchangeDTO.getRates().getPLN()));
        rateList.add(new Rate("RON", exchangeDTO.getRates().getRON()));
        rateList.add(new Rate("RUB", exchangeDTO.getRates().getRUB()));
        rateList.add(new Rate("SEK", exchangeDTO.getRates().getSEK()));
        rateList.add(new Rate("SGD", exchangeDTO.getRates().getSGD()));
        rateList.add(new Rate("THB", exchangeDTO.getRates().getTHB()));
        rateList.add(new Rate("TRY", exchangeDTO.getRates().getTRY()));
        rateList.add(new Rate("USD", exchangeDTO.getRates().getUSD()));
        rateList.add(new Rate("ZAR", exchangeDTO.getRates().getZAR()));

        return rateList;
    }
}