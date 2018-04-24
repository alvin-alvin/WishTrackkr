package com.aclessdev.WishTrackkr.network;

import com.aclessdev.WishTrackkr.R;
import com.aclessdev.WishTrackkr.model.googlesearch.GoogleSearchResult;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by AlvinTan on 08/04/18.
 */

public class GoogleSearchClient {
    private static GoogleSearchClient.RestAPI service;

    public static GoogleSearchClient.RestAPI getClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(logging)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        Request.Builder builder = original.newBuilder().header("Content-Type", "application/json");
                        Request request = builder.build();

                        return chain.proceed(request);
                    }
                }).readTimeout(30, TimeUnit.SECONDS).build();

        if (service == null)

        {
            Retrofit client = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("https://www.googleapis.com/customsearch/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            service = client.create(GoogleSearchClient.RestAPI.class);
        }
        return service;
    }

    public interface RestAPI {

        @GET("v1")
        Call<GoogleSearchResult> getImageByQuery(@Query("q") String query,
                                                 @Query("cx") String cx,
                                                 @Query("searchType") String searchType,
                                                 @Query("key") String key);



    }
}
