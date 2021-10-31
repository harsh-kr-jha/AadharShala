package com.example.aadharshala2.placeholder;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.aadharshala2.Api;
import com.example.aadharshala2.RetrofitClient;
import com.example.aadharshala2.model.result_otp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;




/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PlaceholderContent {



    /**
     * An array of sample (placeholder) items.
     */
    public static final List<PlaceholderItem> ITEMS = new ArrayList<PlaceholderItem>();

    /**
     * A map of sample (placeholder) items, by ID.
     */
    public static final Map<String, PlaceholderItem> ITEM_MAP = new HashMap<String, PlaceholderItem>();









    /**
     * A placeholder item representing a piece of content.
     */
    public static class PlaceholderItem {
        public final String reqCode;


        public PlaceholderItem(String reqCode) {
            this.reqCode = reqCode;

        }

        @Override
        public String toString() {
            return reqCode;
        }
    }


}