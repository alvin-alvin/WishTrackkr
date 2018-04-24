package com.aclessdev.WishTrackkr.shared;

import android.content.res.Configuration;
import android.support.multidex.MultiDexApplication;

import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by AlvinTan on 18/03/18.
 */

public class BaseApplication extends MultiDexApplication {


    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
