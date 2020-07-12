package com.TruDoc.Weather.ui.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.TruDoc.Weather.R;
import com.TruDoc.Weather.data.network.pojo.OpenWeather5Day;
import com.TruDoc.Weather.ui.base.BaseActivity;
import com.TruDoc.Weather.utils.DividerItemDecoration;

import com.shuhart.stickyheader.StickyHeaderItemDecorator;

import java.text.ParseException;

import javax.inject.Inject;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class MainActivity extends BaseActivity implements MainMvpView, MainAdapter.Callback, SwipeRefreshLayout.OnRefreshListener {

    RecyclerView mRecyclerView;

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @Inject
    MainAdapter mRssAdapter;

    LinearLayoutManager mLayoutManager;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    TextView txtCityName;
    double lat,lng;
    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
        mPresenter.onAttach(MainActivity.this);
        setUp();

    }

    @Override
    protected void setUp() {
        mRecyclerView = findViewById(R.id.recycler_daily_weathers);
        txtCityName = findViewById(R.id.txtName);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.divider_drawable);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(dividerDrawable));
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRssAdapter.setCallback(this);
        StickyHeaderItemDecorator decorator = new StickyHeaderItemDecorator(mRssAdapter);
        decorator.attachToRecyclerView(mRecyclerView);

        lat = getIntent().getDoubleExtra("lat",30.033333) ;
         lng = getIntent().getDoubleExtra("lng",31.233334) ;
        mPresenter.getOpenWeather5DaysData(lat,lng);
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void updateView(OpenWeather5Day objOpenWeather5Day) {
        mRecyclerView.setAdapter(mRssAdapter);



        try {


            mRssAdapter.SetItems(objOpenWeather5Day.getDataTemp(),this);
            txtCityName.setText(objOpenWeather5Day.getCity().getName());
            mSwipeRefreshLayout.setRefreshing(false);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onEmptyViewRetryClick() {
       // mPresenter.getOpenWeather5DaysData();
    }

    @Override
    public void onRefresh() {
        mPresenter.getOpenWeather5DaysData(lat,lng);
    }
}
