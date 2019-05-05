package com.mcc.q1_gallary_project.Interface;

import com.mcc.q1_gallary_project.Pojo.ImagePojo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface ImageApi {
    @POST("/mobsvc/ContentFile.php")
    Call<ImagePojo> getImageDetails(@Field("AppId") String AppId, @Field("MenuId") String MenuId);
}
