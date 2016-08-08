package com.alxdevand.forecast.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alxdevand.forecast.ActApplication;
import com.cricut.act.R;
import com.alxdevand.forecast.model.ForecastSpecification;
import com.alxdevand.forecast.util.StringValues;

public class DetailsFragment extends Fragment {

    private static final String EXTRA_FORECAST = String.format("%s.%s", DetailsFragment.class.getName(), "EXTRA_FORECAST");
    private static final String EXTRA_STRING = String.format("%s.%s", DetailsFragment.class.getName(), "EXTRA_STRING");
    private ForecastSpecification mForecastSpecification;
    private TextView mTextViewDate;
    private TextView mTextViewDay;
    private TextView mTextViewHigh;
    private TextView mTextViewLow;
    private TextView mTextViewText;
    private ImageView mImageViewDescription;

    public static DetailsFragment newInstance(ForecastSpecification forecastSpecification, String title) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_FORECAST, forecastSpecification);
        bundle.putString(EXTRA_STRING, title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        if (getArguments() != null) {
            mForecastSpecification = getArguments().getParcelable(EXTRA_FORECAST);
            String title = getArguments().getString(EXTRA_STRING);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        }

        mTextViewDate = (TextView) view.findViewById(R.id.textView_date);
        mTextViewDay = (TextView) view.findViewById(R.id.textView_day);
        mTextViewHigh = (TextView) view.findViewById(R.id.textView_high);
        mTextViewLow = (TextView) view.findViewById(R.id.textView_low);
        mTextViewText = (TextView) view.findViewById(R.id.textView_text);
        mImageViewDescription = (ImageView) view.findViewById(R.id.imageView_description);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTextViewDate.setText(mForecastSpecification.getDate());
        mTextViewDay.setText(mForecastSpecification.getDay());
        mTextViewHigh.setText(mForecastSpecification.getHigh());
        mTextViewLow.setText(mForecastSpecification.getLow());
        mTextViewText.setText(mForecastSpecification.getText());
        String urlImg = StringValues.getInstance().getImgUrl(mForecastSpecification.getCode());
        ActApplication.getInstance().getGlideLouderImage().loadImg(urlImg, mImageViewDescription);
    }
}
