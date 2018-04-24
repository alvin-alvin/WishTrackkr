package com.aclessdev.WishTrackkr;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.aclessdev.WishTrackkr.model.product.GetProductByIdResponse;
import com.aclessdev.WishTrackkr.network.RestClient;
import com.aclessdev.WishTrackkr.shared.BackgroundScapper;
import com.aclessdev.WishTrackkr.shared.BaseActivity;
import com.bumptech.glide.Glide;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddWishAcitivty extends BaseActivity {

    public RestClient.RestAPI client;
    @BindView(R.id.addProductImage)
    ImageView addProductImage;
    @BindView(R.id.addProductName)
    EditText addProductName;
    @BindView(R.id.addProductPrice)
    EditText addProductPrice;
    @BindView(R.id.addProductUrl)
    EditText addProductUrl;

    static int GET_FROM_GALERY = 12;

    Intent intent;
    GetProductByIdResponse product;

    public static final String TAG = AddWishAcitivty.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_wish_acitivty);
        ButterKnife.bind(this);


        client = RestClient.getClient();

        intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();


        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if (type.equals("text/plain")) {
                setDataFromUrl();
            }
        } else {
            inputProductManually();
        }
    }

    private void inputProductManually() {
        addProductPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

//                Toast.makeText(AddWishAcitivty.this, editable.toString(), Toast.LENGTH_SHORT).show();
                addProductPrice.removeTextChangedListener(this);
                addProductPrice.setText(thousandSeparator(Integer.parseInt(editable.toString())));

            }
        });

        if (addProductPrice.hasFocus()) {
            String value = addProductPrice.getText().toString();
            value = value.replace("Rp", "");
            value = value.replace(".", "");

            addProductPrice.setText(value);
        } else {
            if (!addProductPrice.getText().toString().equalsIgnoreCase("")) {
                addProductPrice.setText(thousandSeparator(Integer.parseInt(addProductPrice.getText().toString())));
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GET_FROM_GALERY && resultCode == Activity.RESULT_OK){
            Uri selectedImage = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),selectedImage);
                addProductImage.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setDataFromUrl() {
        String url = intent.getStringExtra(Intent.EXTRA_TEXT);

        if (isBukalapak(url)) {
            disableEditText();
            fetchBukalapakData(url);
        }
        if (isTokopedia(url)) {
            disableEditText();
            fetchTokopediaData(url);
        } else {
            addProductUrl.setText(intent.getStringExtra(Intent.EXTRA_TEXT));
        }

    }

    public void disableEditText() {
        addProductPrice.setEnabled(false);
        addProductUrl.setEnabled(false);
    }


    @OnClick({R.id.addProductImage, R.id.btnAddWishlist})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addProductImage:
                startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI), GET_FROM_GALERY);


                break;
            case R.id.btnAddWishlist:
                product.getProduct().setName(addProductName.getText().toString());
                realm.beginTransaction();
                realm.insertOrUpdate(product);
                realm.commitTransaction();
                Toast.makeText(this, "wishlist saved", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }

    private boolean isBukalapak(String url) {

        if (url.contains("https://www.bukalapak.com/p/")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isTokopedia(String url) {
        if (url.contains("https://www.tokopedia.com/")) {
            return true;
        } else {
            return false;
        }
    }

    private void fetchBukalapakData(final String url) {
        //ex : https://www.bukalapak.com/p/handphone/hp-smartphone/eir7qr-jual-promo-xiaomi-redmi-5a-ram-2-16gb-resmi?from=homepage&panel=8&type=popular-products-section-4&g=m
        //     https://www.bukalapak.com/p/fashion-pria/tas-pria/punggung-backpack/7x3fv7-jual-tas-pria-ransel-backpack-tas-punggung-tas-outdoor-tas-traveling-harga-grosir-langsung-dari-konveksi-tas

        String[] urlParts = url.split("/");
        String product_id;
        if (urlParts.length == 7) {
            product_id = urlParts[6];
        } else {
            product_id = urlParts[7];
        }
        Call<GetProductByIdResponse> getProduct = client.getProductById(product_id);
        getProduct.enqueue(new Callback<GetProductByIdResponse>() {
            @Override
            public void onResponse(Call<GetProductByIdResponse> call, Response<GetProductByIdResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equalsIgnoreCase("ERROR")) {
                        //KIRIM ULR PRODUCT KE FIREBASE ANALYTIC BUAT DI TEST
                    } else {
                        product = response.body();
                        addProductName.setText("Product name = " + product.getProduct().getName());
                        addProductPrice.setText(thousandSeparator(product.getProduct().getPrice()));
                        addProductUrl.setText(url);
                        product.getProduct().setProductLink(url);
                        Glide.with(AddWishAcitivty.this).load(response.body().getProduct().getImages().get(0)).into(addProductImage);
                        Log.i("AddWishActivity", "Image = " + response.body().getProduct().getImages().get(0));
                        Log.i("Get Product", "Product name = " + response.body().getProduct().getName());
                    }

                } else {
                    Toast.makeText(AddWishAcitivty.this, "Response not successfull", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetProductByIdResponse> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(AddWishAcitivty.this, "Gagal memuat data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fetchTokopediaData(String url) {
        try {
            GetProductByIdResponse product = new BackgroundScapper().execute(url).get();
            this.product = product;
            addProductName.setText(product.getProduct().getName());
            addProductPrice.setText(thousandSeparator(product.getProduct().getPrice()));
            addProductUrl.setText(product.getProduct().getProductLink());
            Glide.with(AddWishAcitivty.this).load(product.getProduct().getImages().get(0)).into(addProductImage);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private String thousandSeparator(int price) {
        return "Rp." + NumberFormat.getNumberInstance(new Locale("in")).format(price);
    }



}
