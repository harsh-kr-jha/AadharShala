package com.example.aadharshala2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import com.example.aadharshala2.model.auth_aadhar;
import com.example.aadharshala2.model.cred;
import com.example.aadharshala2.model.listOfTenants;
import com.example.aadharshala2.model.result_otp;
import com.example.aadharshala2.model.token;
import com.example.aadharshala2.placeholder.PlaceholderContent;

import java.util.List;


public interface Api {
    String BASE_URL = "http://127.0.0.1:8000/server/gen_otp/";




    @POST("/server/gen_otp/")
    Call<result_otp> genOTP(@Body auth_aadhar aadhar_no);

    @POST("/server/ver_otp/")
    Call<result_otp> verOTP(@Body cred cred);

    @POST("/server/get_landlord_tenants/")
    Call<listOfTenants> getLandlordTenants(@Body token token);

}
