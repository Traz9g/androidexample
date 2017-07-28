package com.traz.exampleapp.model.api;

import com.traz.exampleapp.model.dto.ExchangeDTO;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by TRaz on 27.07.17.
 * Have to work
 */

public interface ApiInterface {

    @GET("/latest")
    Observable<ExchangeDTO> getRepositories();
}