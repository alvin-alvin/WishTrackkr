package com.aclessdev.WishTrackkr.shared;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import io.realm.Realm;

/**
 * Created by AlvinTan on 18/03/18.
 */

public class BaseActivity extends AppCompatActivity {

    public Realm realm;
    public AppPreference appPreference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        realm = Realm.getDefaultInstance();
        appPreference = new AppPreference(getApplicationContext());
    }
}
