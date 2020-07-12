package com.TruDoc.Weather.ui.Details;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.TruDoc.Weather.R;
import com.TruDoc.Weather.data.network.pojo.DetailsItem;
import com.TruDoc.Weather.data.network.pojo.OpenWeather5Day;
import com.TruDoc.Weather.ui.base.BaseViewHolder;
import com.TruDoc.Weather.utils.UI;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class DetailsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private static final String TAG = "RssAdapter";
    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private List<DetailsItem> mItemList;
    Activity mActivity;
    public DetailsAdapter(List<DetailsItem> temList) {
        mItemList = temList;
    }



    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.details_row, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mItemList != null && mItemList.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (mItemList != null && mItemList.size() > 0) {
            return mItemList.size();
        } else {
            return 1;
        }
    }

    public void setItems(List<DetailsItem> sportList, Activity activity) {
        mItemList.addAll(sportList);
        mActivity = activity;
        notifyDataSetChanged();

    }



    public class ViewHolder extends BaseViewHolder {

        ImageView thumbnail;
        TextView titleTextView;



        public ViewHolder(View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.imageView);
            titleTextView = itemView.findViewById(R.id.textView2);

        }

        protected void clear() {
            thumbnail.setImageDrawable(null);
            titleTextView.setText("");

        }

        public void onBind(int position) {
            super.onBind(position);

           titleTextView.setText(mItemList.get(position).getName() +" "+ mItemList.get(position).getValue());

            Glide.with(mActivity)
                    .load(UI.getImage(mItemList.get(position).getIcon(),mActivity))
                    .apply(RequestOptions.fitCenterTransform().centerCrop())
                    .transition(DrawableTransitionOptions.withCrossFade())

                    .into(thumbnail);


        }
    }

    public class EmptyViewHolder extends BaseViewHolder {

        TextView messageTextView;
        TextView buttonRetry;

        EmptyViewHolder(View itemView) {
            super(itemView);


        }

        @Override
        protected void clear() {

        }

    }
}
