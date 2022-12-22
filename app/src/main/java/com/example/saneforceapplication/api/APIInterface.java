package com.example.saneforceapplication.api;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface APIInterface {
    @FormUrlEncoded
    @POST("db.php?axn=get/doctors")
    Call<List<ListDataResponse>> getData(@Field("data") String data);
}
