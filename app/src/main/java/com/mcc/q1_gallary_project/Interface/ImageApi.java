package com.mcc.q1_gallary_project.Interface;

import com.mcc.q1_gallary_project.Pojo.Contentfilelist;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ImageApi {
    @FormUrlEncoded
    @POST("/mobsvc/ContentFile.php")
    Call<Contentfilelist> getImageDetails(@Field("AppId") String AppId, @Field("MenuId") String MenuId);
}
