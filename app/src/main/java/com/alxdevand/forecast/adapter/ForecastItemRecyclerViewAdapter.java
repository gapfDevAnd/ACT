package com.alxdevand.forecast.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alxdevand.forecast.ActApplication;
import com.cricut.act.R;
import com.alxdevand.forecast.model.ForecastSpecification;
import com.alxdevand.forecast.util.StringValues;

import java.util.List;

public class ForecastItemRecyclerViewAdapter extends RecyclerView.Adapter<ForecastItemRecyclerViewAdapter.ViewHolder> {

    private final List<ForecastSpecification> mValues;

    public ForecastItemRecyclerViewAdapter(List<ForecastSpecification> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_forecast, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.textViewDate.setText(mValues.get(position).getDate());
        holder.textViewDay.setText(mValues.get(position).getDay());
        holder.textViewText.setText(mValues.get(position).getText());
        String urlImg = StringValues.getInstance().getImgUrl(mValues.get(position).getCode());
        ActApplication.getInstance().getGlideLouderImage().loadImg(urlImg, holder.imageViewForeCast);
    }

    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView textViewDate;
        public final TextView textViewText;
        private final ImageView imageViewForeCast;
        private final TextView textViewDay;

        public ViewHolder(View view) {
            super(view);
            imageViewForeCast = (ImageView) view.findViewById(R.id.imageView_forecastLogo);
            textViewDate = (TextView) view.findViewById(R.id.textView_daterow);
            textViewDay = (TextView) view.findViewById(R.id.textView_dayrow);
            textViewText = (TextView) view.findViewById(R.id.textView_textrow);
        }
    }
}
