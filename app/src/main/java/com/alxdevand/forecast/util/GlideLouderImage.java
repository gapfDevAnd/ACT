package com.alxdevand.forecast.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;

public class GlideLouderImage {

    private Context mContext;

    public GlideLouderImage(Context context) {
        this.mContext = context;
    }

    public static GlideLouderImage getInstance(Context context) {
        return new GlideLouderImage(context);
    }

    public void loadImg(String urlImg, ImageView imageView) {
        if (!urlImg.equals("")) {
            Glide.with(mContext)
                    .load(urlImg)
                    .asBitmap()
                    .placeholder(android.R.drawable.ic_dialog_info)
                    .error(android.R.drawable.ic_delete)
                    .into(imageView);
        }
    }

    public void loadImgTarget(String urlImg, SimpleTarget<Bitmap> simpleTarget) {
        if (!urlImg.equals("")) {
            Glide.with(mContext)
                    .load(urlImg)
                    .asBitmap()
                    .placeholder(android.R.drawable.ic_dialog_info)
                    .error(android.R.drawable.ic_delete)
                    .into(simpleTarget);
        }
    }
}
