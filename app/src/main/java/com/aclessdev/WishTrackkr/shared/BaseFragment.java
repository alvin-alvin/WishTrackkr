package com.aclessdev.WishTrackkr.shared;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import io.realm.Realm;

/**
 * Created by AlvinTan on 30/03/18.
 */

public class BaseFragment extends Fragment {

    public Realm realm;
    public AppPreference appPreference;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        realm = Realm.getDefaultInstance();
        appPreference = new AppPreference(getContext().getApplicationContext());
    }
}
