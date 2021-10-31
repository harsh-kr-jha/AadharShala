package com.example.aadharshala2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aadharshala2.model.listOfTenants;
import com.example.aadharshala2.model.tenant;
import com.example.aadharshala2.model.token;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A fragment representing a list of Items.
 */
public class tenantrequestFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    public static final String PREF ="com.example.aadharshala2.savedtoken";
    public static final String SECRET_KEY= "token";
    public String spm;
    public token token;
    public listOfTenants tanentObject;
    public List<tenant> tean= Arrays.asList(new tenant("3232"),new tenant("6372"),new tenant("4322"));

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public tenantrequestFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static tenantrequestFragment newInstance(int columnCount) {
        tenantrequestFragment fragment = new tenantrequestFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

        SharedPreferences sp = getActivity().getSharedPreferences(PREF , Context.MODE_PRIVATE);
        spm = sp.getString(SECRET_KEY,null);
        token = new token(spm);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tenant_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
//            if (mColumnCount <= 1) {
//                recyclerView.setLayoutManager(new LinearLayoutManager(context));
//            } else {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
//            getLandlordTenants(token);



            recyclerView.setAdapter(new MytenantrequestRecyclerViewAdapter(tean));
            //here is where we are going to pass in the array of all the tenents registered to the landlord
        }
        return view;
    }

    private void getLandlordTenants(com.example.aadharshala2.model.token token) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000/")

                // as we are sending data in json format so
                // we have to add Gson converter factory
                .addConverterFactory(GsonConverterFactory.create())
                // at last we are building our retrofit builder.
                .build();

        Api retrofitAPI = retrofit.create(Api.class);
        Call<listOfTenants> call = retrofitAPI.getLandlordTenants(token);


        call.enqueue(new Callback<listOfTenants>() {
            @Override
            public void onResponse(Call<listOfTenants> call, Response<listOfTenants> response) {
                 tanentObject = response.body();
                 Log.e("Status", tanentObject.getStatus());
                 Log.e("hello", String.valueOf(tanentObject.getList().get(0)));
            }

            @Override
            public void onFailure(Call<listOfTenants> call, Throwable t) {

            }
        });



    }}
