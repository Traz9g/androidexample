package com.traz.exampleapp.model;

import com.traz.exampleapp.model.dto.ExchangeDTO;

import rx.Observable;

public interface Model {

    Observable<ExchangeDTO> getExchangeList();
}