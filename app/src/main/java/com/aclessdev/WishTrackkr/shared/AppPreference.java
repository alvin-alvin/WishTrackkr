package com.aclessdev.WishTrackkr.shared;

import android.content.Context;
import android.content.SharedPreferences;

import com.aclessdev.WishTrackkr.model.authentication.UserProfile;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by AlvinTan on 31/03/18.
 */

public class AppPreference {
    private static final String PREF_NAME = "WishTrackkr";
    private static final int PREF_MODE = 0;
    private static final String USER_ID = "userid";
    private static final String USER_EMAIL = "useremail";
    private static final String USER_PROFILE = "userprofile";


    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private Context mContext;

    public AppPreference(Context context) {
        mContext = context;
        mSharedPreferences = mContext.getSharedPreferences(PREF_NAME, PREF_MODE);
    }

    public String getUserId() {
        return mSharedPreferences.getString(USER_ID, "");
    }

    public void setUserId(String userId) {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(USER_ID, userId);
        mEditor.apply();
    }

    public void removeUserId() {
        mEditor = mSharedPreferences.edit();
        mEditor.remove(USER_ID);
        mEditor.apply();
    }

    public String getUserEmail() {
        return mSharedPreferences.getString(USER_EMAIL, "");
    }

    public void setUserEmail(String userEmail) {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(USER_EMAIL, userEmail);
        mEditor.apply();
    }

    public UserProfile getUserProfile() {
        Gson gson = new Gson();
        Type type = new TypeToken<UserProfile>() {
        }.getType();
        String json = mSharedPreferences.getString(USER_PROFILE, "");
        UserProfile obj = gson.fromJson(json, type);
        if (obj != null) {
            return obj;
        } else {
            return null;
        }
    }

    public void setUserProfile(UserProfile profileStatus) {
        Gson gson = new Gson();
        String json = gson.toJson(profileStatus);
        mEditor = mSharedPreferences.edit();
        mEditor.putString(USER_PROFILE, json);
        mEditor.apply();
    }
}
