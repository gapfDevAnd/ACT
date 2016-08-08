package com.alxdevand.forecast.api;

import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;

public class YahooForecastBuilder {

    private static final String BASE_URL = "https://query.yahooapis.com/";

    public static YahooForecastBuilder getInstance() {
        return new YahooForecastBuilder();
    }

    public YahooForecastApi getBuilder() {
        OkHttpClient okHttpClient = new OkHttpClient();

        Retrofit build = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return build.create(YahooForecastApi.class);
    }

}
