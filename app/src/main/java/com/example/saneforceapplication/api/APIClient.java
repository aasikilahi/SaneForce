package com.example.saneforceapplication.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static final String BASE_URL = "https://sanffr.info/iOSServer/";

    private static Retrofit retrofit = null;

    public static Retrofit getAPIClient() {
        retrofit = null;
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.MINUTES).readTimeout(10, TimeUnit.MINUTES).addInterceptor(interceptor).build();

        try {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        } catch (Exception e) {
        }
        return retrofit;
    }
}
