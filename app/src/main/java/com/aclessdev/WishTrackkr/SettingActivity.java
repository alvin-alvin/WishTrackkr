package com.aclessdev.WishTrackkr;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import com.aclessdev.WishTrackkr.authentication.SplashScreen;
import com.aclessdev.WishTrackkr.shared.BaseActivity;
import com.facebook.login.LoginManager;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {

    public static final String TAG = SettingActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.settingBtnLogout)
    public void onClick() {
        setupAlertLogout();
    }

    private void setupAlertLogout() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);


        builder.setCancelable(false);
        builder.setMessage("Apakah anda yakin untuk keluar?");
        builder.setNegativeButton("Keluar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                LoginManager.getInstance().logOut();
                appPreference.setUserProfile(null);
                Intent goLogout = new Intent(SettingActivity.this, SplashScreen.class);
                startActivity(goLogout);
            }
        });

        builder.setPositiveButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        final AlertDialog dialog = builder.create();
//        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
//            @Override
//            public void onShow(DialogInterface dialogInterface) {
//                dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.merahBukalapak,null));
//            }
//        });
        dialog.show();




    }


}
