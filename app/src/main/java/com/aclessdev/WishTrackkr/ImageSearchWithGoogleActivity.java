package com.aclessdev.WishTrackkr;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.aclessdev.WishTrackkr.model.googlesearch.GoogleSearchResult;
import com.aclessdev.WishTrackkr.network.GoogleSearchClient;
import com.aclessdev.WishTrackkr.shared.BaseActivity;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageSearchWithGoogleActivity extends BaseActivity {

    @BindView(R.id.searchImageET)
    EditText searchImageET;
    @BindView(R.id.testImage)
    ImageView testImage;
    private GoogleSearchClient.RestAPI googleClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_search_with_google);
        ButterKnife.bind(this);

        googleClient = GoogleSearchClient.getClient();



    }

    @OnClick(R.id.searchImageButton)
    public void onClick() {
        String query = searchImageET.getText().toString();

    }
}
