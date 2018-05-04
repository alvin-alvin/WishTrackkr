package com.aclessdev.WishTrackkr.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.aclessdev.WishTrackkr.MainActivity;
import com.aclessdev.WishTrackkr.R;
import com.aclessdev.WishTrackkr.shared.BaseActivity;

import butterknife.ButterKnife;

public class SplashScreen extends BaseActivity {

    private static final String TAG = SplashScreen.class.getSimpleName();
    private int SPLASH_DURATION = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent navigateHome = new Intent(getBaseContext(), MainActivity.class);
                startActivity(navigateHome);
            }
        }, SPLASH_DURATION);
        
    }


}
