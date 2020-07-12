package com.TruDoc.Weather.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.TruDoc.Weather.R;
import com.TruDoc.Weather.data.network.pojo.Details;
import com.TruDoc.Weather.data.network.pojo.DetailsItem;
import com.TruDoc.Weather.data.network.pojo.OpenWeather5Day;
import com.TruDoc.Weather.ui.Details.DetailsActivity;
import com.TruDoc.Weather.ui.base.BaseViewHolder;
import com.TruDoc.Weather.utils.ItemType;
import com.TruDoc.Weather.utils.UI;
import com.bumptech.glide.Glide;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.shuhart.stickyheader.StickyAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;

/**
 * Created on : Feb 11, 2019
 * Author     : AndroidWave
 */
public class MainAdapter extends StickyAdapter<BaseViewHolder, BaseViewHolder> {
    private static final String TAG = "RssAdapter";
    private Callback mCallback;
    ArrayList<OpenWeather5Day.List> weatherList = new ArrayList<>();
    Activity mActivity;
    public MainAdapter(ArrayList<OpenWeather5Day.List> weatherList) {

    }



    public void setCallback(Callback callback) {
        mCallback = callback;
    }



    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


            if(viewType == ItemType.Header) {
                return new HeaderViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.header, parent, false));
            }
        else if(viewType == ItemType.Post) {
            return new ViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed, parent, false));
        }
            else if(viewType == ItemType.VIEW_TYPE_EMPTY) {
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false));
            }
            else
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed, parent, false));


    }

    @Override
    public void onBindViewHolder(BaseViewHolder  holder, int position) {
        holder.onBind(position);
    }


    @Override
    public int getItemViewType(int position) {
        if (weatherList != null && weatherList.size() > 0) {

            if (weatherList.get(position).getCelltype()== null)
                return ItemType.Post;
                else

             return ItemType.Header;
        } else {
            return ItemType.VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (weatherList != null && weatherList.size() > 0) {
            return weatherList.size();
        } else {
            return 1;
        }
    }

    public void SetItems(ArrayList<OpenWeather5Day.List> weatherList, Activity activity) {
        mActivity  = activity;
        this.weatherList = weatherList;
        notifyDataSetChanged();
    }

    @Override
    public int getHeaderPositionForItem(int itemPosition) {
        return  weatherList.get(itemPosition).getSectionPostion();
    }

    @Override
    public void onBindHeaderViewHolder(BaseViewHolder baseViewHolder, int position) {
        baseViewHolder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        return createViewHolder(parent, ItemType.Header);
    }


    public interface Callback {
        void onEmptyViewRetryClick();
    }

    public class ViewHolder extends BaseViewHolder {


        TextView tvTempMax,tvTempMin,tvWeatherDate,tvWeather;

        AppCompatImageView imageItem;
        ConstraintLayout layout;
        public ViewHolder(View itemView) {
            super(itemView);

            layout = itemView.findViewById(R.id.layout);
            tvTempMax = itemView.findViewById(R.id.text_temp_max);
            tvTempMin = itemView.findViewById(R.id.text_temp_min);
            tvWeatherDate = itemView.findViewById(R.id.textViewDataTime);
            tvWeather = itemView.findViewById(R.id.text_weather);
            imageItem = itemView.findViewById(R.id.image_icon_city_item);


        }

        protected void clear() {

            tvTempMax.setText("");
            tvTempMin.setText("");
            tvWeatherDate.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);
            String date = "";
            try {
                 date = setDateFormat(weatherList.get(position).getDtTxt());
            } catch (ParseException e) {
                e.printStackTrace();
            };
            tvWeatherDate.setText(date);

                tvTempMin.setText( String.valueOf(weatherList.get(position).getMain().getTempMin()));
                tvTempMax.setText(String.valueOf(weatherList.get(position).getMain().getTempMax()));
            tvWeather.setText(weatherList.get(position).getWeather().get(0).getMain());

            Glide.with(mActivity)
                    .load(UI.getImage("weather_icon_"+weatherList.get(position).getWeather().get(0).getIcon(),mActivity))
                    .apply(RequestOptions.fitCenterTransform().centerCrop())
                    .transition(DrawableTransitionOptions.withCrossFade())

                    .into(imageItem);


            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   Details obj =  getDetailsData(position);
                    Intent intent = new Intent(mActivity, DetailsActivity.class);
                    intent.putExtra("data", obj);
                    mActivity.startActivity(intent);
                }
            });
            }




    }

    class HeaderViewHolder extends BaseViewHolder {
        public TextView title;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }

        @Override
        protected void clear() {

        }

        public void onBind(int position) {
            {
                title.setText(weatherList.get(position).getTitle());
            }
        }
    }
    private String setDateFormat(String unformattedDate) throws ParseException {

        Date dateformat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").parse(unformattedDate);
        return (new SimpleDateFormat("HH:mm")).format(dateformat);
    }

    public class EmptyViewHolder extends BaseViewHolder {

        TextView messageTextView;
        TextView buttonRetry;

        EmptyViewHolder(View itemView) {
            super(itemView);
            buttonRetry = itemView.findViewById(R.id.buttonRetry);
            buttonRetry.setOnClickListener(v ->
                    mCallback.onEmptyViewRetryClick()
            );
        }

        @Override
        protected void clear() {

        }

    }


    private  Details getDetailsData(int postion)
    {
        ArrayList<DetailsItem> lstItems = new ArrayList();
        DetailsItem objDetailsItem= new DetailsItem();
        objDetailsItem.setName("Temperature min");
        objDetailsItem.setValue(String.valueOf(weatherList.get(postion).getMain().getTempMin()));
        objDetailsItem.setIcon("ic_thermometer_white_24dp");
        lstItems.add(objDetailsItem);

        objDetailsItem= new DetailsItem();
        objDetailsItem.setName("Temperature max");
        objDetailsItem.setValue(String.valueOf(weatherList.get(postion).getMain().getTempMax()));
        objDetailsItem.setIcon("ic_thermometer_white_24dp");
        lstItems.add(objDetailsItem);


        objDetailsItem= new DetailsItem();
        objDetailsItem.setName("Temperature");
        objDetailsItem.setValue(String.valueOf(weatherList.get(postion).getMain().getTemp()));
        objDetailsItem.setIcon("ic_thermometer_white_24dp");
        lstItems.add(objDetailsItem);


        objDetailsItem= new DetailsItem();
        objDetailsItem.setName("Pressure");
        objDetailsItem.setValue(String.valueOf(weatherList.get(postion).getMain().getPressure()));
        objDetailsItem.setIcon("ic_pressure_black_24dp");
        lstItems.add(objDetailsItem);

        objDetailsItem= new DetailsItem();
        objDetailsItem.setName("Humidity");
        objDetailsItem.setValue(String.valueOf(weatherList.get(postion).getMain().getHumidity()));
        objDetailsItem.setIcon("ic_humidity_black_24dp");
        lstItems.add(objDetailsItem);

        objDetailsItem= new DetailsItem();
        objDetailsItem.setName("Clouds");
        objDetailsItem.setValue(String.valueOf(weatherList.get(postion).getClouds().getAll()));
        objDetailsItem.setIcon("ic_cloud_black_24dp");
        lstItems.add(objDetailsItem);

        objDetailsItem= new DetailsItem();
        objDetailsItem.setName("Wind speed:");
        objDetailsItem.setValue(String.valueOf(weatherList.get(postion).getWind().getSpeed()));
        objDetailsItem.setIcon("ic_windy_white_24dp");
        lstItems.add(objDetailsItem);


        objDetailsItem= new DetailsItem();
        objDetailsItem.setName("Wind direction");
        objDetailsItem.setValue(String.valueOf(weatherList.get(postion).getWind().getDeg()));
        objDetailsItem.setIcon("ic_windy_white_24dp");
        lstItems.add(objDetailsItem);


        Details objDetails = new Details();
        objDetails.setDate(weatherList.get(postion).getDtTxt());
        objDetails.setStatus(weatherList.get(postion).getWeather().get(0).getMain());
        objDetails.setIcon(weatherList.get(postion).getWeather().get(0).getIcon());


        objDetails.setLstItems(lstItems);
        return  objDetails;
    }

}
