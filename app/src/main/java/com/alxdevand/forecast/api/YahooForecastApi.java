package com.alxdevand.forecast.api;

import com.alxdevand.forecast.model.Forecast;

import retrofit2.http.GET;
import rx.Observable;

public interface YahooForecastApi {

    @GET("v1/public/yql?q=select%20%2a%20from%20weather.forecast%20where%20woeid%20in%20%28select%20woeid%20from%20geo.places%281%29%20where%20text%3D\"nome%2c%20ak\"%29&format=json&env=store://datatables.org/alltableswithkeys")
    Observable<Forecast> getForecast();
}
