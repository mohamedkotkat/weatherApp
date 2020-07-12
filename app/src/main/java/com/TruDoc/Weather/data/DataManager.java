package com.TruDoc.Weather.data;

import com.TruDoc.Weather.data.db.dao.UserDao;
import com.TruDoc.Weather.data.network.RestApiHelper;
import com.TruDoc.Weather.data.prefs.PreferencesHelper;
import com.TruDoc.Weather.data.utils.LoggedInMode;

public interface DataManager extends UserDao, PreferencesHelper, RestApiHelper {
    void updateApiHeader(Long userId, String accessToken);

    void setUserLoggedOut();

    void updateUserInfo(
            String accessToken,
            Long userId,
            LoggedInMode loggedInMode,
            String userName,
            String email,
            String profilePicPath);
}
