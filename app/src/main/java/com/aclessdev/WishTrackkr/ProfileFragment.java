package com.aclessdev.WishTrackkr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aclessdev.WishTrackkr.adapter.MainWishlistAdapter;
import com.aclessdev.WishTrackkr.model.product.GetProductByIdResponse;
import com.aclessdev.WishTrackkr.shared.BaseFragment;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileFragment extends BaseFragment {
    //Add impelemnts OnStartDragListener to enable 'hold to change direction' or 'swipe left to remove'

    @BindView(R.id.profileImageView)
    ImageView profileImageView;
    @BindView(R.id.profileUsername)
    TextView profileUsername;
    @BindView(R.id.rvList)
    RecyclerView rvList;

    MainWishlistAdapter adapter;
    //    private ItemTouchHelper touchHelper;
    List<GetProductByIdResponse> listProduct;
    @BindView(R.id.profileBirthday)
    TextView profileBirthday;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);
        setHasOptionsMenu(true);
        setupUser();
        setupRV();
        return view;
    }

    private void setupUser() {
        if (appPreference.getUserProfile() != null) {
            profileUsername.setText(appPreference.getUserProfile().getName());
            profileBirthday.setText(appPreference.getUserProfile().getBirthday());
            Glide.with(this).load(appPreference.getUserProfile().getProfilePicture()).into(profileImageView);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.setListProduct(realm.where(GetProductByIdResponse.class).findAll());
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuAdd:
                Intent goAdd = new Intent(getContext(), AddWishAcitivty.class);
                startActivity(goAdd);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupRV() {
        listProduct = new ArrayList<>();
        listProduct = realm.where(GetProductByIdResponse.class).findAll();
//        adapter = new MainWishlistAdapter(getContext(),listProduct,this,realm);
        adapter = new MainWishlistAdapter(getContext(), listProduct, realm);
        rvList.setNestedScrollingEnabled(false);
        rvList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvList.setNestedScrollingEnabled(false);
        rvList.setAdapter(adapter);

//        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
//        touchHelper = new ItemTouchHelper(callback);
//        touchHelper.attachToRecyclerView(rvList);
    }

    @OnClick(R.id.profileSettingBtn)
    public void onClick() {
        Intent goToSetting = new Intent(getContext(), SettingActivity.class);
        startActivity(goToSetting);
    }


//    @Override
//    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
//        touchHelper.startDrag(viewHolder);
//    }
}
