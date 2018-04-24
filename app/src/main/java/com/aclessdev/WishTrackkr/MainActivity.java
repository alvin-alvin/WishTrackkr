package com.aclessdev.WishTrackkr;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.widget.FrameLayout;

import com.aclessdev.WishTrackkr.shared.BaseActivity;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements  BottomNavigationBar.OnTabSelectedListener{


    @BindView(R.id.mainBottomNavigation)
    BottomNavigationBar mainBottomNavigation;
    @BindView(R.id.mainPlaceholder)
    FrameLayout mainPlaceholder;

    List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainBottomNavigation.setTabSelectedListener(this);
        setupFragments();
        refresh();
    }

    private void setupFragments(){
        mFragments.add(HomeFragment.newInstance());
        mFragments.add(ProfileFragment.newInstance());
    }

    private void refresh(){
        mainBottomNavigation.clearAll();

        final int color = ContextCompat.getColor(this,R.color.black);
        final int inactive_color = ContextCompat.getColor(this,R.color.gray400);
        mainBottomNavigation.setBarBackgroundColor(R.color.white);
        mainBottomNavigation.addItem(new BottomNavigationItem(R.drawable.ic_home_black_24dp,"Home").setActiveColor(color).setInActiveColor(inactive_color))
                .addItem(new BottomNavigationItem(R.drawable.ic_person_black_24dp,"Profile").setActiveColor(color).setInActiveColor(inactive_color))
                .setFirstSelectedPosition(0)
                .initialise();
        mainBottomNavigation.setAutoHideEnabled(false);
        onTabSelected(0);
    }


    @Override
    public void onTabSelected(int position) {
        switch (position){
            case 0:
                if (getSupportFragmentManager().findFragmentByTag("Home")==null){
                    getSupportFragmentManager().beginTransaction().add(R.id.mainPlaceholder,mFragments.get(position),"Home").commit();
                }else{
                    switchFragment(position);
                }
                getSupportActionBar().setTitle("Home");
                break;

            case 1:
                if (getSupportFragmentManager().findFragmentByTag("Profile")==null){
                    getSupportFragmentManager().beginTransaction().add(R.id.mainPlaceholder,mFragments.get(position),"Profile").commit();
                }else{
                    switchFragment(position);
                }
                getSupportActionBar().setTitle("Profile");
                break;

        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    private void switchFragment(int position) {
        hideFragments();
        getSupportFragmentManager().beginTransaction().show(mFragments.get(position)).commit();
    }

    private void hideFragments() {
        for (int i = 0; i < mFragments.size(); i++) {
            if (mFragments.get(i).isVisible())
                getSupportFragmentManager().beginTransaction().hide(mFragments.get(i)).commit();
        }
    }
}
