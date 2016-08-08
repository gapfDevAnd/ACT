package com.alxdevand.forecast.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alxdevand.forecast.ActApplication;
import com.cricut.act.R;
import com.alxdevand.forecast.adapter.ForecastItemRecyclerViewAdapter;
import com.alxdevand.forecast.listener.RecyclerItemClickListener;
import com.alxdevand.forecast.model.Forecast;
import com.alxdevand.forecast.model.ForecastSpecification;
import com.alxdevand.forecast.ui.activity.DetailActivity;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ForecastFragment extends Fragment {

    private Subscription mSubscription;
    private List<ForecastSpecification> mForecastSpecifications;
    private RecyclerView mRecyclerView;
    private Forecast mForecast;

    public ForecastFragment() {
    }

    public static ForecastFragment newInstance() {
        return new ForecastFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forecast_item_list, container, false);
        initList(view);
        initApiForecast();
        return view;
    }

    private void initList(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void initApiForecast() {
        Observable<Forecast> forecastObservable = ActApplication.getInstance().getYahooForecastApi().getForecast();
        mSubscription = forecastObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Forecast>() {
                    @Override
                    public void onCompleted() {

                        ForecastItemRecyclerViewAdapter forecastItemRecyclerViewAdapter = new ForecastItemRecyclerViewAdapter(mForecastSpecifications);
                        mRecyclerView.setAdapter(forecastItemRecyclerViewAdapter);
                        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(int position) {
                                Intent intent = new Intent(getContext(), DetailActivity.class);
                                intent.putExtra(DetailActivity.EXTRA_OBJECT_DETAILS
                                        , mForecastSpecifications.get(position));
                                intent.putExtra(DetailActivity.EXTRA_STRING_DETAILS
                                        , mForecast.getQuery().getResults().getChannel().getItem().getTitle());
                                getContext().startActivity(intent);
                            }

                            @Override
                            public void onItemLongClick() {

                            }
                        }));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Forecast forecast) {
                        mForecast = forecast;
                        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(forecast.getQuery().getResults().getChannel().getTitle());
                        mForecastSpecifications = forecast.getQuery().getResults().getChannel().getItem().getForecast();
                        setLouder(View.GONE);
                    }
                });
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mSubscription.unsubscribe();
    }

    public void setLouder(int type) {
        (getView().findViewById(R.id.relativeLayout_louder)).setVisibility(View.GONE);
    }
}
