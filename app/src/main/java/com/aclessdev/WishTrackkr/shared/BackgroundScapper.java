package com.aclessdev.WishTrackkr.shared;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.aclessdev.WishTrackkr.AddWishAcitivty;
import com.aclessdev.WishTrackkr.model.product.GetProductByIdResponse;
import com.aclessdev.WishTrackkr.model.product.Product;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

/**
 * Created by AlvinTan on 31/03/18.
 */

public class BackgroundScapper extends AsyncTask<String ,Void, GetProductByIdResponse> {
    public static final String TAG = BackgroundScapper.class.getSimpleName();
    String name;
    public GetProductByIdResponse product;
    RealmList<String> productImage = new RealmList<>();



    @Override
    protected GetProductByIdResponse doInBackground(String... strings) {
        Document document = null;
        try {
            document = Jsoup.connect(strings[0]).userAgent("Mozilla").data("query", "Java").get();
            Element body = document.body();

            productImage.add(body.select("img").select("#prod-img-primary").attr("src"));

            String name = body.select("input").select("#product-name").attr("value");
            int price = Integer.parseInt(body.select("input").select("#product_price_int").attr("value"));
            String id = body.select("input").select("#unique_id").attr("value");
            String link = body.select("input").select("#product-url").attr("value");

            product = new GetProductByIdResponse();
            product.setProduct(new Product());
            product.getProduct().setName(name);
            product.getProduct().setProductLink(link);
            product.getProduct().setPrice(price);
            product.getProduct().setId(id);
            product.getProduct().setImages(productImage);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    protected void onPostExecute(GetProductByIdResponse product) {
        super.onPostExecute(product);
//        new AddWishAcitivty().setData(product);
    }

    //
//    @Override
//    protected void onPostExecute(Void aVoid) {
//        super.onPostExecute(aVoid);
//        new AddWishAcitivty().setData(product);
//    }

}
