package com.TruDoc.Weather.ui.Details;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.TruDoc.Weather.R;
import com.TruDoc.Weather.data.network.pojo.Details;
import com.TruDoc.Weather.data.network.pojo.OpenWeather5Day;
import com.TruDoc.Weather.ui.base.BaseActivity;
import com.TruDoc.Weather.ui.main.MainMvpPresenter;
import com.TruDoc.Weather.ui.main.MainMvpView;
import com.TruDoc.Weather.utils.DividerItemDecoration;
import com.TruDoc.Weather.utils.UI;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import javax.inject.Inject;

public class DetailsActivity extends BaseActivity implements MainMvpView {

    RecyclerView mRecyclerView;
    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;
    @Inject
    DetailsAdapter mAdapter;
    LinearLayoutManager mLayoutManager;
    TextView date,text_main,text_description;
    ImageView img;
    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, DetailsActivity.class);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        getActivityComponent().inject(this);
        mPresenter.onAttach(DetailsActivity.this);
        initView();
        setUp();

    }
    @Override
    protected void setUp() {




        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.divider_gray);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(dividerDrawable));
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        if (getIntent().getSerializableExtra("data") != null)
        {
            Details obj = (Details) getIntent().getSerializableExtra("data");
            date.setText(obj.getDate());
            text_main.setText(obj.getStatus());
            Glide.with(this)
                    .load(UI.getImage("weather_icon_"+ obj.getIcon(),this))
                    .apply(RequestOptions.fitCenterTransform().centerCrop())
                    .transition(DrawableTransitionOptions.withCrossFade())

                    .into(img);
            mAdapter.setItems(obj.getLstItems(),this);
        }





    }
    void initView(){
        mRecyclerView = findViewById(R.id.recycler_detail);
         date = findViewById(R.id.text_data_time);
         text_main = findViewById(R.id.text_main);
         text_description = findViewById(R.id.text_description);
         img = findViewById(R.id.image_icon);


    }

    @Override
    public void updateView(OpenWeather5Day objOpenWeather5Day) {

    }
}
