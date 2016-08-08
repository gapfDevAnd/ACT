package com.alxdevand.forecast;

import android.app.Application;

import com.alxdevand.forecast.api.YahooForecastApi;
import com.alxdevand.forecast.api.YahooForecastBuilder;
import com.alxdevand.forecast.util.GlideLouderImage;

public class ActApplication extends Application {
    private static ActApplication mInstance;
    private YahooForecastApi mYahooForecastApi;
    private GlideLouderImage mGlideLouderImage;

    public static ActApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (!(mInstance != null)) {
            mInstance = this;
        }

        initApi();
        initGlide();
    }

    private void initGlide() {
        mGlideLouderImage = GlideLouderImage.getInstance(getApplicationContext());
    }

    private void initApi() {
        mYahooForecastApi = YahooForecastBuilder.getInstance().getBuilder();
    }

    public YahooForecastApi getYahooForecastApi() {
        return mYahooForecastApi;
    }

    public GlideLouderImage getGlideLouderImage() {
        return mGlideLouderImage;
    }
}
