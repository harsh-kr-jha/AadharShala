package com.example.aadharshala2.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.aadharshala2.Api;
// com.example.aadharshala2.RetrofitClient = /Users/sunday/AndroidStudioProjects/AadharShala2/app/src/main/java/com.example.aadharshala2.RetrofitClient.java

import com.example.aadharshala2.R;
import com.example.aadharshala2.dashboard;
import com.example.aadharshala2.databinding.ActivityDashboardBinding;
import com.example.aadharshala2.databinding.ActivityNewLoginBinding;
import com.example.aadharshala2.model.auth_aadhar;
import com.example.aadharshala2.model.cred;
import com.example.aadharshala2.model.result_otp;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewLoginActivity extends AppCompatActivity {

    private ActivityNewLoginBinding binding;
    private com.example.aadharshala2.RetrofitClient RetrofitClient;
    private String token;
    SharedPreferences sharedpreferences;
    public static final String PREF ="com.example.aadharshala2.savedtoken";
    public static final String SECRET_KEY= "token";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityNewLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sp = getSharedPreferences(PREF , Context.MODE_PRIVATE);
        String token  = sp.getString(SECRET_KEY,null);


        final EditText usernameEditText = binding.username;
        final Button loginButton = binding.login;
        final ProgressBar loadingProgressBar = binding.loading;
        final EditText otpEditText = binding.otp;
        final Button verifyOtp = binding.verifyOtp;






        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login(usernameEditText.getText().toString());

            }
        });

        verifyOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                verifyOTP(otpEditText.getText().toString());

            }
        });





    }





    public void login (String username){
        Log.e(username, username);
        getSuperHeroes(username);


//        api call
//
//        if (status == 'y') {
//            isOtpValid();
//            if ( askforotp();){
//                launch new dashboard activity
//            } else{
//                loginResult.setValue(new LoginResult(R.string.login_failed));
//            }
//        } else {
//            print error code
//        }

    }

//    private boolean isOtpValid(String token){

    private boolean otpScreen(){
        View b = findViewById(R.id.verify_otp);
        b.setVisibility(View.VISIBLE);



        View c = findViewById(R.id.otp);
        c.setVisibility(View.VISIBLE);
        View d = findViewById(R.id.login);
        d.setVisibility(View.INVISIBLE);
        View e = findViewById(R.id.username);
        e.setVisibility(View.INVISIBLE);


        return true;
    }



    private void verifyOTP(String otp){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000/")

                // as we are sending data in json format so
                // we have to add Gson converter factory
                .addConverterFactory(GsonConverterFactory.create())
                // at last we are building our retrofit builder.
                .build();
        // below line is to create an instance for our retrofit api class.
        Api retrofitAPI = retrofit.create(Api.class);

        cred credentials = new cred(otp, token  );

        Call<result_otp> call = retrofitAPI.verOTP(credentials);
        call.enqueue(new Callback<result_otp>() {
            @Override
            public void onResponse(Call<result_otp> call, Response<result_otp> response) {
                result_otp responseFromAPI = response.body();

                if(responseFromAPI.getStatus().equals("Y") || responseFromAPI.getStatus().equals("y")){

                    // save the token
                    Log.e("token", token);
                    SharedPreferences sp = getSharedPreferences(PREF, Context.MODE_PRIVATE);
                    sp.edit().putString(SECRET_KEY,responseFromAPI.getToken()).commit();
                    Log.e("token", token);
                    //  start dashboard activity //
                    Intent myIntent = new Intent(NewLoginActivity.this, dashboard.class);

                    NewLoginActivity.this.startActivity(myIntent);






                }else {Log.e("response", responseFromAPI.getStatus());}

            }

            @Override
            public void onFailure(Call<result_otp> call, Throwable t) {
                Log.e("Error", "onFailure: ",t );
            }
        });

    }





    private void getSuperHeroes(String username) {
        Log.e(username, username);




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000/")

                // as we are sending data in json format so
                // we have to add Gson converter factory
                .addConverterFactory(GsonConverterFactory.create())
                // at last we are building our retrofit builder.
                .build();
        // below line is to create an instance for our retrofit api class.
        Api retrofitAPI = retrofit.create(Api.class);

        // passing data from our text fields to our modal class.
        auth_aadhar modal = new auth_aadhar(username);


        Call<result_otp> call = retrofitAPI.genOTP(modal);

        call.enqueue(new Callback<result_otp>() {
            @Override
            public void onResponse(Call<result_otp> call, Response<result_otp> response) {
                // this method is called when we get response from our api.
                //Toast.makeText(MainActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();
                Log.e("username", "my name is khan");
                // below line is for hiding our progress bar.
//                loadingPB.setVisibility(View.GONE);

                // on below line we are setting empty text
                // to our both edit text.
//                usernameEditText.setText("");
//                nameEdt.setText("");



                // we are getting response from our body
                // and passing it to our modal class.
                result_otp responseFromAPI = response.body();

                if(responseFromAPI.getStatus().equals("Y") || responseFromAPI.getStatus().equals("y")){
                    otpScreen();

                    token = responseFromAPI.getToken();

                }else {Log.e("response", responseFromAPI.getStatus());}



                // on below line we are getting our data from modal class and adding it to our string.
//                String responseString = "Response Code : " + response.code() + "\nStatus : " + responseFromAPI.getStatus() + "\n" ;


//                + "Token : " + responseFromAPI.getToken()


                // below line we are setting our
                // string to our text view.
                Log.e("response", "nhi hai yes");
            }

            @Override
            public void onFailure(Call<result_otp> call, Throwable t) {
                // setting text to our text view when
                // we get error response from API.
//               responseTV.setText("Error found is : " + t.getMessage());
                Log.e("Error", "onFailure: ",t );
            }
        });
    }
}
//}


