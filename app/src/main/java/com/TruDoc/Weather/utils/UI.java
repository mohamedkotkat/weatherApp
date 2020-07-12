package com.TruDoc.Weather.utils;

import android.app.Activity;

public class UI {

    public static int getImage(String imageName, Activity mActivity ) {

        int drawableResourceId = mActivity.getResources().getIdentifier(imageName, "drawable", mActivity.getPackageName());

        return drawableResourceId;
    }
}
