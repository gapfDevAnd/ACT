package com.alxdevand.forecast.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.alxdevand.forecast.ActApplication;
import com.cricut.act.R;
import com.alxdevand.forecast.model.ForecastSpecification;
import com.alxdevand.forecast.ui.fragment.DetailsFragment;
import com.alxdevand.forecast.util.StringValues;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_OBJECT_DETAILS = String.format("%s.%s", DetailActivity.class.getName(), "EXTRA_OBJECT_DETAILS");
    public static final String EXTRA_STRING_DETAILS = String.format("%s.%s", DetailActivity.class.getName(), "EXTRA_STRING_DETAILS");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_details);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent() != null) {
            ForecastSpecification forecastSpecification = getIntent().getParcelableExtra(EXTRA_OBJECT_DETAILS);
            String title = getIntent().getStringExtra(EXTRA_STRING_DETAILS);
            getSupportActionBar().setTitle(forecastSpecification.getText());
            final ImageView imageViewForecast = (ImageView) findViewById(R.id.imageView_toolbarImg);
            final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout_details);
            String urlImg = StringValues.getInstance().getImgUrl(forecastSpecification.getCode());
            ActApplication.getInstance().getGlideLouderImage().loadImgTarget(urlImg, new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                    imageViewForecast.setImageBitmap(resource);
                    Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                        @Override
                        public void onGenerated(Palette palette) {
                            int primaryDark = getResources().getColor(R.color.colorPrimaryDark);
                            int primary = getResources().getColor(R.color.colorPrimary);
                            collapsingToolbarLayout.setStatusBarScrimColor(palette.getLightMutedColor(primaryDark));
                            collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(primary));
                            collapsingToolbarLayout.setBackgroundColor(palette.getMutedColor(primaryDark));
                            supportStartPostponedEnterTransition();
                        }
                    });
                }
            });

            if (savedInstanceState == null) {
                addFragment(forecastSpecification, title);
            }


        }

    }

    private void addFragment(ForecastSpecification forecastSpecification, String title) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frameLayout_details, DetailsFragment.newInstance(forecastSpecification, title));
        fragmentTransaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
