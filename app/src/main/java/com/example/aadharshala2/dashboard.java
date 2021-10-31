package com.example.aadharshala2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.aadharshala2.ui.main.SectionsPagerAdapter;
import com.example.aadharshala2.databinding.ActivityDashboardBinding;

public class dashboard extends AppCompatActivity {

    private ActivityDashboardBinding binding;
    public static final String PREF ="com.example.aadharshala2.savedtoken";
    public static final String SECRET_KEY= "token";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.addTab(tabs.newTab().setText(R.string.landlord));
        tabs.addTab(tabs.newTab().setText(R.string.tenant));
        tabs.addTab(tabs.newTab().setText("Harsh"));

        SharedPreferences sp = getSharedPreferences(PREF , Context.MODE_PRIVATE);
        String token  = sp.getString(SECRET_KEY,null);






        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = binding.fab;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}